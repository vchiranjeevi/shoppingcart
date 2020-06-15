package com.mindtree.shoppingcart.service;

import com.mindtree.shoppingcart.entity.Cart;
import com.mindtree.shoppingcart.exception.ShoppingCartException;

/**
 * @author M1044610
 *
 */
public interface CartService {
	
	public void removeFromCart(Cart cart);
	
	public void removeAllProductsFromCart(Cart cart);

	public void updateQuantity(Cart cart) throws ShoppingCartException;
}
