/**
 * 
 */
package com.sbhol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbhol.entity.User;
import com.sbhol.exception.ShoppingCartException;
import com.sbhol.service.UserService;

/**
 * @author M1044610
 *
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public void addProduct(@RequestBody User user) throws ShoppingCartException{
		if(user.getCart().getQuantity() >= 0) { 
			userService.addUser(user);
		} else {
			throw new ShoppingCartException("Product Quantity Should be Positive");
		}
	}

}
