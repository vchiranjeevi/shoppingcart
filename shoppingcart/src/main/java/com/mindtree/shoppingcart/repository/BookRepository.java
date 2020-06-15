/**
 * 
 */
package com.mindtree.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.shoppingcart.entity.Book;

/**
 * @author M1044610
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	
}
