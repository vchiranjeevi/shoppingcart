/**
 * 
 */
package com.sbhol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhol.entity.Cart;
import com.sbhol.entity.User;
import com.sbhol.exception.ShoppingCartException;
import com.sbhol.repository.CartRepository;
import com.sbhol.repository.UserRepository;
import com.sbhol.service.CartService;

/**
 * @author M1044610
 *
 */
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void removeFromCart(Cart cart) {
		List<User> users = userRepository.findByUserName(cart.getUser().getUserName());
		List<Cart> carts = cartRepository.findCart(cart.getProductId(), users.get(0).getUserName());
		if(null != carts && !carts.isEmpty()) {
			/*
			 * if(carts.get(0).getQuantity() > 1) {
			 * cartRepository.removeCartByProductId(carts.get(0).getQuantity() - 1,
			 * users.get(0).getCartId(), cart.getProductId()); } else
			 * if(carts.get(0).getQuantity() == 1) {
			 */
			cartRepository.removeCartByProductId(0, users.get(0).getCartId(), cart.getProductId());
			//}
		}
		
	}
	
	@Override
	public void removeAllProductsFromCart(Cart cart) {
		List<User> users = userRepository.findByUserName(cart.getUser().getUserName());
		cartRepository.removeAllProductsFromCart(0, users.get(0).getCartId());
		/*
		 * cart.getProduct().forEach(products ->{
		 * cartRepository.removeAllProductsFromCart(0, users.get(0).getCartId()); });
		 */
		
	}

	@Override
	public void updateQuantity(Cart cart) throws ShoppingCartException {
		List<User> users = userRepository.findByUserName(cart.getUser().getUserName());
		if(cart.getQuantity() >= 0) {
			cartRepository.updateQuantity(cart.getQuantity(), cart.getProductId(), users.get(0).getCartId());
		} else {
			throw new ShoppingCartException("Product Quantity Should be Positive");
		}
	}

}
