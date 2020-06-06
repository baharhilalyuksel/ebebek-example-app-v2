package com.example.ebebek.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	List<CartLine> cartLines;
	Double totalPrice;

	public Cart() {
		cartLines = new ArrayList<CartLine>();
	}

	public void addCartLine(CartLine cartLine) {
		cartLines.add(cartLine);
	}

	public CartLine getCardLine(int productId) {
		for (CartLine cartLine : cartLines) {
			if(cartLine.getProduct().getId() == productId) {
				return cartLine;
			}
		}
		return null;
	}

	public List<CartLine> getCartLines() {
		return cartLines;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void calculateTotalPrice() {
		totalPrice = 0.0;
		for (CartLine cartLine : cartLines) {
			totalPrice += cartLine.getTotalPrice();
		}
	}

	public void removeCartLine(CartLine cartLine) {
		cartLines.remove(cartLine);
	}
	

}
