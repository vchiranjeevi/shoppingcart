package com.mindtree.shoppingcart.service;

import java.util.List;

import com.mindtree.shoppingcart.entity.Apparal;
import com.mindtree.shoppingcart.entity.Book;
import com.mindtree.shoppingcart.entity.Product;
import com.mindtree.shoppingcart.entity.User;
import com.mindtree.shoppingcart.model.ProductPrice;

/**
 * @author M1044610
 *
 */
public interface ProductService {
	
	public Book getBookProductById(Integer productId);
	
	public Apparal getApparalProductById(Integer productId);
	
	public void addBookProduct(List<Book> book);
	
	public void addApparalProduct(List<Apparal> apparal);
	
	public List<Product> getBookProducts();
	
	public List<Product> getApparalProducts();
	
	public List<Product> fetchAllProducts();

	public List<ProductPrice> getAllUserProductDetails(User user);
	
	

}
