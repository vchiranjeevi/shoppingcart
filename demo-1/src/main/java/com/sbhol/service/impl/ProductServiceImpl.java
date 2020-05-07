/**
 * 
 */
package com.sbhol.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhol.entity.Apparal;
import com.sbhol.entity.Book;
import com.sbhol.entity.Cart;
import com.sbhol.entity.Product;
import com.sbhol.entity.User;
import com.sbhol.model.ProductPrice;
import com.sbhol.repository.ApparalRepository;
import com.sbhol.repository.BookRepository;
import com.sbhol.repository.CartRepository;
import com.sbhol.repository.ProductRepository;
import com.sbhol.service.ProductService;

/**
 * @author M1044610
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	

	@Autowired
	private BookRepository bookRepository;
	

	@Autowired
	private ApparalRepository apparalRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	public List<Product> fetchAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProduct(Integer productId) {
		Optional<Product> products =  productRepository.findById(productId);
		if(products.isPresent()) {
			return products.get();
		}
		return new Product();
	}
	
	public Book getBookProductById(Integer productId) {
		Optional<Book> bookInfo = bookRepository.findById(productId);
		if(bookInfo.isPresent()) {
			return bookInfo.get();
		}
		return new Book();
	}
	
	public Apparal getApparalProductById(Integer productId) {
		Optional<Apparal> appInfo = apparalRepository.findById(productId);
			if(appInfo.isPresent()) {
				return appInfo.get();
			}
		return new Apparal();
	}

	public void addBookProduct(List<Book> book) {
		book.forEach(b -> bookRepository.save(b));
	}
	
	public void addApparalProduct(List<Apparal> apparal) {
		apparal.forEach(a -> apparalRepository.save(a));
	}

	@Override
	public List<Product> getBookProducts() {
		return productRepository.findProductByCategory("Book");
		
	}

	@Override
	public List<Product> getApparalProducts() {
		return productRepository.findProductByCategory("Apparal");
	}

	@Override
	public List<ProductPrice> getAllUserProductDetails(User user) {
		List<Cart> userCarts = cartRepository.findUserCart(user.getUserName());
		List<Product> userProducts = productRepository.fetchAllUserProducts(user.getUserName());
		List<ProductPrice> productPrices = new ArrayList<>();
		userCarts.forEach(cart -> {
			userProducts.forEach(product -> {
				if(cart.getProductId() == product.getProductId()) {
					ProductPrice userProductPrice = new ProductPrice();
					userProductPrice.setProductId(product.getProductId());
					userProductPrice.setQuantity(cart.getQuantity());
					userProductPrice.setPrice(cart.getQuantity() * product.getProductPrice());
					productPrices.add(userProductPrice);
				}
			});
		});
		return productPrices;
	}
}
