/**
 * 
 */
package com.sbhol.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductRepository productRepository;
	

	@Autowired
	private BookRepository bookRepository;
	

	@Autowired
	private ApparalRepository apparalRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	public List<Product> fetchAllProducts() {
		logger.info("In ProductServiceImpl.fetchAllProducts fetch all products");
		return productRepository.findAll();
	}
	
	public Product getProduct(Integer productId) {
		logger.info("In ProductServiceImpl.getProduct fetch the product by product id");
		Optional<Product> products =  productRepository.findById(productId);
		if(products.isPresent()) {
			return products.get();
		}
		return new Product();
	}
	
	public Book getBookProductById(Integer productId) {
		logger.info("ProductServiceImpl.getBookProductById get book product by book product id");
		Optional<Book> bookInfo = bookRepository.findById(productId);
		if(bookInfo.isPresent()) {
			return bookInfo.get();
		}
		return new Book();
	}
	
	public Apparal getApparalProductById(Integer productId) {
		logger.info("ProductServiceImpl.getApparalProductById get apparal product by apparal product id");
		Optional<Apparal> appInfo = apparalRepository.findById(productId);
			if(appInfo.isPresent()) {
				return appInfo.get();
			}
		return new Apparal();
	}

	public void addBookProduct(List<Book> book) {
		logger.info("ProductServiceImpl.addBookProduct add the book");
		book.forEach(b -> bookRepository.save(b));
	}
	
	public void addApparalProduct(List<Apparal> apparal) {
		logger.info("ProductServiceImpl.addApparalProduct add the apparal");
		apparal.forEach(a -> apparalRepository.save(a));
	}

	@Override
	public List<Product> getBookProducts() {
		logger.info("ProductServiceImpl.getBookProducts get the product by category");
		return productRepository.findProductByCategory("Book");
		
	}

	@Override
	public List<Product> getApparalProducts() {
		logger.info("ProductServiceImpl.getApparalProducts get the product by category");
		return productRepository.findProductByCategory("Apparal");
	}

	@Override
	public List<ProductPrice> getAllUserProductDetails(User user) {
		logger.info("ProductServiceImpl.getAllUserProductDetails get all products bought by the user and display the total amount paid by the user");
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
