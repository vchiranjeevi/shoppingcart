/**
 * 
 */
package com.sbhol.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhol.entity.Cart;
import com.sbhol.entity.User;
import com.sbhol.repository.CartRepository;
import com.sbhol.repository.UserRepository;
import com.sbhol.service.UserService;

/**
 * @author M1044610
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Transactional
	@Override
	public void addUser(User user) {
		Integer cartId = 0;
		if(null != cartRepository.max()) {
			cartId = cartRepository.max();
		}
		List<Cart> carts = cartRepository.findCart(user.getCart().getProductId(), user.getUserName());
		List<User> users = userRepository.findByUserName(user.getUserName());
		if(null != users && !users.isEmpty() && null != carts && !carts.isEmpty()) {
			int qty = carts.get(0).getQuantity() + 1;
			cartRepository.updateCart(qty, user.getCart().getProductId(), carts.get(0).getCartId());
			/*
			 * Optional<Product> product =
			 * productRepository.findById(user.getCart().getProductId());
			 * if(product.isPresent()) { productRepository.updateProductPrice(qty *
			 * product.get().getProductPrice(), product.get().getProductId()); }
			 */
			
			
		} else if(null != users && !users.isEmpty() && carts.isEmpty()) {
			user.getCart().setCartId(users.get(0).getCartId());
			user.setCartId(users.get(0).getCartId());
			cartRepository.save(user.getCart());
		} else {
			
			user.setCartId(cartId + 1);
			user.getCart().setCartId(user.getCartId());
			userRepository.save(user);
		}
		
		
			
		//}
	}

}
