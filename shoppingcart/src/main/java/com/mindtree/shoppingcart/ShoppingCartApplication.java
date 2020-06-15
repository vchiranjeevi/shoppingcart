package com.mindtree.shoppingcart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.mindtree.shoppingcart"})
public class ShoppingCartApplication {

	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartApplication.class);
	
	public static void main(String[] args) {
		logger.info("Start the application from main class");
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

}
