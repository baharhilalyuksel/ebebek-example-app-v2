package com.example.ebebek.model;

public class CartLine {
	
	Product product;
	Integer quantity;
	Double totalPrice;
	
	public CartLine() {
	}

	public CartLine(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
		totalPrice = this.product.getPrice()*this.quantity;
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
		totalPrice = this.product.getPrice()*this.quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void incrementQuantity() {
		quantity++;
		totalPrice = this.product.getPrice()*this.quantity;
	}
	
	public void decrementQuantity() {
		quantity--;
		totalPrice = this.product.getPrice()*this.quantity;
	}

}
