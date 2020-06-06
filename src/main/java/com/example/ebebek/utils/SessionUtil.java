package com.example.ebebek.utils;

import javax.servlet.http.HttpServletRequest;

import com.example.ebebek.model.Cart;

public class SessionUtil {
	
	public static Cart getCartInSession(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("myCart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("myCart", cart);
		}
		return cart;
	}

}
