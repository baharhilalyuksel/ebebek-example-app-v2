package com.example.ebebek.model;

public class ChangeProductQuantityResultBean {
	
	private Cart cart;
	private CartLine cartLine;
	
	public ChangeProductQuantityResultBean(Cart cart, CartLine cartLine) {
		this.cart = cart;
		this.cartLine = cartLine;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public CartLine getCartLine() {
		return cartLine;
	}
	public void setCartLine(CartLine cartLine) {
		this.cartLine = cartLine;
	}

}
