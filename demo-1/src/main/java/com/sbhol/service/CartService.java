package com.sbhol.service;

import com.sbhol.entity.Cart;
import com.sbhol.exception.ShoppingCartException;

/**
 * @author M1044610
 *
 */
public interface CartService {
	
	public void removeFromCart(Cart cart);
	
	public void removeAllProductsFromCart(Cart cart);

	public void updateQuantity(Cart cart) throws ShoppingCartException;
}
