/**
 * 
 */
package com.sbhol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sbhol.entity.Product;

/**
 * @author M1044610
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Modifying
	@Query("UPDATE Product p set p.productPrice =:productPrice where p.productId =:productId")
	public void updateProductPrice(double productPrice, int productId);
	
	
	@Query("Select p from Product p where p.productName = :productName")
	public List<Product> findProductByCategory(String productName);
	
	@Query("Select p from Product p inner join Cart c on c.productId=p.productId inner join User u on u.cartId=c.cartId where u.userName = :userName")
	public List<Product> fetchAllUserProducts(String userName);
	

}
