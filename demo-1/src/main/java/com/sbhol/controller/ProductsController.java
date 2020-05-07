/**
 * 
 */
package com.sbhol.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbhol.entity.Apparal;
import com.sbhol.entity.Book;
import com.sbhol.entity.Product;
import com.sbhol.entity.User;
import com.sbhol.model.ProductPrice;
import com.sbhol.service.ProductService;

/**
 * @author M1044610
 *
 */
@RestController
public class ProductsController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/products/book/{id}")
	public Book getBookProductById(@PathVariable String id) {
		return productService.getBookProductById(Integer.valueOf(id));
	}
	
	@GetMapping(value="/products/apparal/{id}")
	public Apparal getApparalProductById(@PathVariable String id) {
		return productService.getApparalProductById(Integer.valueOf(id));
	}
	
	@GetMapping(value="/products/{category}")
	public List<Product> getApparalProductByCategory(@PathVariable String category) {
		if("Book".equalsIgnoreCase(category)) {
			return productService.getBookProducts();
		} else if("Apparal".equalsIgnoreCase(category)) {
			return productService.getApparalProducts();
		}
		return null;
	}
	
	@PostMapping("/addBookProducts")
	public void addProduct(@RequestBody List<Book> book){
		productService.addBookProduct(book);
	}
	
	@PostMapping("/addApparalProducts")
	public void addApparalProduct(@RequestBody List<Apparal> apparal){
		productService.addApparalProduct(apparal);
	}
	
	@GetMapping(value="/products")
	public List<Product> getAllProducts() {
		return productService.fetchAllProducts();
	}
	
	@PostMapping(value="/products/fectchUserProducts")
	public Map<Object, Object> fectchUserProducts(@RequestBody User user) {
		List<ProductPrice> list = productService.getAllUserProductDetails(user);
		Map<Object, Object> map = new HashMap<>();
		map.put("Products", list);
		final double totalAmount[] = {0.0};
		list.forEach(obj -> {
			totalAmount[0] += obj.getPrice();
		});
		map.put("totalAmount", totalAmount[0]);
		return map;
	}
}
