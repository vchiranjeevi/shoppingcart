/**
 * 
 */
package com.mindtree.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.entity.User;

/**
 * @author M1044610
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByUserName(String userName);

}
