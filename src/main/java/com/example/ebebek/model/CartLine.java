package com.example.ebebek.model;

import java.math.BigDecimal;

public class CartLine {
	
	Product product;
	Integer quantity;
	BigDecimal totalPrice;
	
	public CartLine() {
	}

	public CartLine(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
		totalPrice = this.product.getPrice().multiply(new BigDecimal(this.quantity));
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
		totalPrice = this.product.getPrice().multiply(new BigDecimal(this.quantity));
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void incrementQuantity() {
		quantity++;
		totalPrice = this.product.getPrice().multiply(new BigDecimal(this.quantity));
	}
	
	public void decrementQuantity() {
		quantity--;
		totalPrice = this.product.getPrice().multiply(new BigDecimal(this.quantity));
	}

}
