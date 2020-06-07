package com.example.ebebek.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ebebek.model.Cart;
import com.example.ebebek.model.CartLine;
import com.example.ebebek.model.Product;

@Service
public class ECommerceServiceImpl implements ECommerceService {
	
	public static List<Product> products;

	public ECommerceServiceImpl() {
		products = new ArrayList<Product>();
		
		products.add(new Product(1, "Product 1", new BigDecimal("29.99"), "https://cdn.e-bebek.com/y.ebebek/logo.svg"));
		products.add(new Product(2, "Product 2", new BigDecimal("48.50"), "https://cdn.e-bebek.com/y.ebebek/logo.svg"));
		products.add(new Product(3, "Product 3", new BigDecimal("120.0"), "https://cdn.e-bebek.com/y.ebebek/logo.svg"));
		products.add(new Product(4, "Product 4", new BigDecimal("4.96"), "https://cdn.e-bebek.com/y.ebebek/logo.svg"));
		products.add(new Product(5, "Product 5", new BigDecimal("50.0"), "https://cdn.e-bebek.com/y.ebebek/logo.svg"));
		products.add(new Product(6, "Product 6", new BigDecimal("599.0"), "https://cdn.e-bebek.com/y.ebebek/logo.svg"));
		products.add(new Product(7, "Product 7", new BigDecimal("800.0"), "https://cdn.e-bebek.com/y.ebebek/logo.svg"));
		products.add(new Product(8, "Product 8", new BigDecimal("8.25"), "https://cdn.e-bebek.com/y.ebebek/logo.svg"));	
	}

	@Override
	public List<Product> getAllProducts() {
		return products;
	}

	@Override
	public Product getProductById(int productId) {
		return products.get(productId-1);
	}

	@Override
	public void addProductToCart(Cart cart, int productId) {
		Product product = getProductById(productId);
		CartLine cartLine = cart.getCardLine(productId);
		if(cartLine == null) {
			cartLine = new CartLine(product, 1);
			cart.addCartLine(cartLine);
		} else {
			cartLine.incrementQuantity();
		}
		cart.calculateTotalPrice();
	}

	@Override
	public void incrementProductQuantity(Cart cart, int productId) {
		CartLine cartLine = cart.getCardLine(productId);
		cartLine.incrementQuantity();
		cart.calculateTotalPrice();
	}

	@Override
	public CartLine getCartLineByProductId(Cart cart, int productId) {
		return cart.getCardLine(productId);
	}

	@Override
	public void decrementProductQuantity(Cart cart, int productId) {
		CartLine cartLine = cart.getCardLine(productId);
		cartLine.decrementQuantity();
		if(cartLine.getQuantity() == 0) {
			cart.removeCartLine(cartLine);
		}
		cart.calculateTotalPrice();
	}


	
	
	
	

}
