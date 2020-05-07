/**
 * 
 */
package com.sbhol.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author M1044610
 *
 */
@Entity
@Table(name="CART")
public class Cart implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "CART_ID", nullable = false, length = 100)
	private int cartId;
	
	@Column(name = "QUANATITY", nullable = false, length = 100)
	private int quantity;
	
	/*
	 * @UpdateTimestamp private Timestamp lastUpdatedTimestamp;
	 */
	
	@OneToOne(mappedBy = "cart")
	private User user;
	
	/*
	 * @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY, orphanRemoval = true )
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Product> product;
	
	@JoinColumn(foreignKey = @ForeignKey(name = "product_id"), name = "product_id")
	private int productId;

	/**
	 * @return the cartId
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProduct() {
		return product;
	}

	/**
	 * @param products the products to set
	 */
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
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
		result = prime * result + cartId;
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + productId;
		result = prime * result + quantity;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productId != other.productId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	
	
	

}
