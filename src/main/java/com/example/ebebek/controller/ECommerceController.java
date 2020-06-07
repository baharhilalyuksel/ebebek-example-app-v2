package com.example.ebebek.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.ebebek.model.Cart;
import com.example.ebebek.service.ECommerceService;
import com.example.ebebek.utils.SessionUtil;

@Controller
public class ECommerceController {
	
	@Autowired
	ECommerceService eCommerceService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/list-products";
	}
	
	@GetMapping("list-products")
	public String listProducts(Model model) {
		model.addAttribute("products", eCommerceService.getAllProducts());
		return "list-products";
	}
	
	@PostMapping("add-product-to-cart")
	public void addProductToCart(HttpServletRequest request, HttpServletResponse response) {
		int productId = Integer.parseInt(request.getParameter("productId"));
		Cart cart = SessionUtil.getCartInSession(request);
		eCommerceService.addProductToCart(cart, productId);
	}
	
	@GetMapping("cart")
	public String showCart(HttpServletRequest request, Model model) {
		Cart cart = SessionUtil.getCartInSession(request);
		cart.calculateTotalPrice();
		model.addAttribute("cart", cart);
		return "cart";
	}
	
	@PostMapping(value = "increment-product-quantity")
	@ResponseBody
	public ModelAndView incrementProductQuantity(@RequestParam Integer productId, HttpServletRequest request) {
		Cart cart = SessionUtil.getCartInSession(request);
		eCommerceService.incrementProductQuantity(cart, productId);
		return new ModelAndView("redirect:/cart");
	}
	
	@PostMapping(value = "decrement-product-quantity")
	@ResponseBody
	public ModelAndView decrementProductQuantity(@RequestParam Integer productId, HttpServletRequest request) {
		Cart cart = SessionUtil.getCartInSession(request);
		eCommerceService.decrementProductQuantity(cart, productId);
		return new ModelAndView("redirect:/cart");
	}

}
