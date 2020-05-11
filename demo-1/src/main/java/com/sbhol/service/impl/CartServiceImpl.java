/**
 * 
 */
package com.sbhol.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void removeFromCart(Cart cart) {
		logger.info("In CartServiceImpl.removeFromCart remove the product from cart");
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
		logger.info("In CartServiceImpl.removeAllProductsFromCart remove all products from cart");
		List<User> users = userRepository.findByUserName(cart.getUser().getUserName());
		cartRepository.removeAllProductsFromCart(0, users.get(0).getCartId());
		/*
		 * cart.getProduct().forEach(products ->{
		 * cartRepository.removeAllProductsFromCart(0, users.get(0).getCartId()); });
		 */
		
	}

	@Override
	public void updateQuantity(Cart cart) throws ShoppingCartException {
		logger.info("In CartServiceImpl.updateQuantity  update the product quantity");
		List<User> users = userRepository.findByUserName(cart.getUser().getUserName());
		if(cart.getQuantity() >= 0) {
			cartRepository.updateQuantity(cart.getQuantity(), cart.getProductId(), users.get(0).getCartId());
		} else {
			logger.info("In CartServiceImpl.removeFromCart  if product quantity negative value throw the exception");
			throw new ShoppingCartException("Product Quantity Should be Positive");
		}
	}

}
