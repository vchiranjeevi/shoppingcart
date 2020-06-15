/**
 * 
 */
package com.mindtree.shoppingcart.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author M1044610
 *
 */
@Entity
@Table(name="USER")
public class User implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "USER_NAME", nullable = false)
	private String userName;
	
	/*
	 * @UpdateTimestamp private Timestamp lastUpdatedTimestamp;
	 */
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
	private Cart cart;
	
	@JoinColumn(foreignKey = @ForeignKey(name = "cart_id"), name = "cart_id")
	private int cartId;

	/**
	 * @return the userId
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + cartId;
		result = prime * result + id;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (cartId != other.cartId)
			return false;
		if (id != other.id)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/**
	 * @return the lastUpdatedTimestamp
	 */
	/*
	 * public Timestamp getLastUpdatedTimestamp() { return lastUpdatedTimestamp; }
	 */

	/**
	 * @param lastUpdatedTimestamp the lastUpdatedTimestamp to set
	 */
	/*
	 * public void setLastUpdatedTimestamp(Timestamp lastUpdatedTimestamp) {
	 * this.lastUpdatedTimestamp = lastUpdatedTimestamp; }
	 */



	
	
	

}
