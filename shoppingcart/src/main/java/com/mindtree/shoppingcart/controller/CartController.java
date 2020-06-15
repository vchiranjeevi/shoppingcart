/**
 * 
 */
package com.mindtree.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shoppingcart.entity.Cart;
import com.mindtree.shoppingcart.exception.ShoppingCartException;
import com.mindtree.shoppingcart.service.CartService;

/**
 * @author M1044610
 *
 */
@RestController
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private  CartService cartService;
	
	@PutMapping("/removeCartById")
	public void removeFromCart(@RequestBody Cart cart){
		logger.info("In CartController.removeFromCart removing produt from cart");
		cartService.removeFromCart(cart);
	}
	
	@PutMapping("/updateQuantity")
	public void updateQuantity(@RequestBody Cart cart) throws ShoppingCartException{
		logger.info("In CartController.updateQuantity updating the quantity");
		cartService.updateQuantity(cart);
	}
	
	@PutMapping("/removeAllProductsFromCart")
	public void removeAllProductsFromCart(@RequestBody Cart cart){
		logger.info("In CartController.removeAllProductsFromCart removing all products from cart");
		cartService.removeAllProductsFromCart(cart);
	}

}
