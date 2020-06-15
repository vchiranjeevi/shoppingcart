/**
 * 
 */
package com.mindtree.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.entity.Apparal;

/**
 * @author M1044610
 *
 */
@Repository
public interface ApparalRepository extends JpaRepository<Apparal, Integer> {
	
	
	

}
