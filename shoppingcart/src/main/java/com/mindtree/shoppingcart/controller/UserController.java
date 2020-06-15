/**
 * 
 */
package com.mindtree.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shoppingcart.entity.User;
import com.mindtree.shoppingcart.exception.ShoppingCartException;
import com.mindtree.shoppingcart.service.UserService;

/**
 * @author M1044610
 *
 */
@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public void addProduct(@RequestBody User user) throws ShoppingCartException{
		logger.info("In UserController.addProduct add the product to the user cart");
		if(user.getCart().getQuantity() >= 0) { 
			userService.addUser(user);
		} else {
			logger.info("In UserController.addProduct throw exception if user added negative quantity");
			throw new ShoppingCartException("Product Quantity Should be Positive");
		}
	}

}
