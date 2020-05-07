package com.sbhol.service;

import java.util.List;

import com.sbhol.entity.Apparal;
import com.sbhol.entity.Book;
import com.sbhol.entity.Product;
import com.sbhol.entity.User;
import com.sbhol.model.ProductPrice;

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
