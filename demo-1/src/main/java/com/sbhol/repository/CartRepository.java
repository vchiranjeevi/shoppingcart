/**
 * 
 */
package com.sbhol.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sbhol.entity.Cart;

/**
 * @author M1044610
 *
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Cart c set c.quantity =:quantity where c.productId =:productId and c.cartId =:cartId")
	public void updateCart(int quantity, int productId, int cartId);
	
	
	@Query("Select max(cartId) from Cart")
	public Integer max();
	
	@Query("Select c from Cart c inner join User u on u.cartId=c.cartId where c.productId=:productId and u.userName = :userName")
	public List<Cart> findCart(int productId, String userName);
	
	@Transactional
	@Modifying
	@Query("Update Cart c set c.quantity =:quantity where c.productId =:productId and c.cartId =:cartId")
	public void removeCartByProductId(int quantity, int productId, int cartId);
	
	@Transactional
	@Modifying
	@Query("Update Cart c set c.quantity =:quantity where c.cartId =:cartId")
	public void removeAllProductsFromCart(int quantity, int cartId);
	
	@Query("Select c from Cart c inner join User u on u.cartId=c.cartId where u.userName = :userName and c.quantity > 0")
	public List<Cart> findUserCart(String userName);
	
	@Transactional
	@Modifying
	@Query("Update Cart c set c.quantity =:quantity where c.productId =:productId and c.cartId =:cartId")
	public void updateQuantity(int quantity, int productId, int cartId);


}
