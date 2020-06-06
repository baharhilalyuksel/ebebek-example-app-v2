package com.example.ebebek.service;

import java.util.List;

import com.example.ebebek.model.Cart;
import com.example.ebebek.model.CartLine;
import com.example.ebebek.model.Product;

public interface ECommerceService {
	
	public List<Product> getAllProducts();
	
	public Product getProductById(int productId);

	public void addProductToCart(Cart cart, int productId);

	public void incrementProductQuantity(Cart cart, int productId);

	public CartLine getCartLineByProductId(Cart cart, int productId);

	public void decrementProductQuantity(Cart cart, int productId);

}
