/**
 * 
 */
package com.sbhol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbhol.entity.Cart;
import com.sbhol.exception.ShoppingCartException;
import com.sbhol.service.CartService;

/**
 * @author M1044610
 *
 */
@RestController
public class CartController {
	
	@Autowired
	private  CartService cartService;
	
	@PutMapping("/removeCartById")
	public void removeFromCart(@RequestBody Cart cart){
		cartService.removeFromCart(cart);
	}
	
	@PutMapping("/updateQuantity")
	public void updateQuantity(@RequestBody Cart cart) throws ShoppingCartException{
		cartService.updateQuantity(cart);
	}
	
	@PutMapping("/removeAllProductsFromCart")
	public void removeAllProductsFromCart(@RequestBody Cart cart){
		cartService.removeAllProductsFromCart(cart);
	}

}
