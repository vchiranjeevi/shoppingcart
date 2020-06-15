/**
 * 
 */
package com.mindtree.shoppingcart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author M1044610
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Product implements Serializable {
	

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", unique = true, nullable = false)
	private int productId;
	
	@Column(name = "PRODUCT_NAME", nullable = false)
	private String productName;
	
	@Column(name = "PRODUCT_PRICE", nullable = false)
	private double productPrice;
	
	
	//private Cart cart;
	
	//private int cid;
	
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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		return true;
	}

	/**
	 * @return the cart
	 */
	
	/* public Cart getCart() { return cart; } */
	 

	/**
	 * @param cart the cart to set
	 */
	
	/* public void setCart(Cart cart) { this.cart = cart; } */

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((cart == null) ? 0 : cart.hashCode()); result =
	 * prime * result + productId; result = prime * result + ((productName == null)
	 * ? 0 : productName.hashCode()); long temp; temp =
	 * Double.doubleToLongBits(productPrice); result = prime * result + (int) (temp
	 * ^ (temp >>> 32)); return result; }
	 */

	
	 

	/**
	 * @return the cid
	 */
	/*
	 * public int getCid() { return cid; }
	 */

	/**
	 * @param cid the cid to set
	 */
	/*
	 * public void setCid(int cid) { this.cid = cid; }
	 */

	
	
	
}
