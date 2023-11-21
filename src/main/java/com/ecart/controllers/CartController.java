package com.ecart.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecart.repository.ProductRepository;
import com.ecart.repository.models.User;
import com.ecart.service.CartService;
import com.ecart.service.OrderService;

import jakarta.servlet.http.HttpSession;

/**
 * Controller to manage the routes for cart and order management
 *
 */
@Controller
public class CartController {

	@Autowired
	public ProductRepository pe;

	@Autowired
	public OrderService os;

	@GetMapping("/cart")
	public String cart(Model model, HttpSession session) {

		User user = ((User) session.getAttribute("user"));
		if (user == null) {
			return "redirect:/welcome";
		}

		Map cart = ((HashMap) session.getAttribute("cart"));
		try {
			CartService.cart = cart;
			CartService.pe = pe;
			CartService.loadCartProducts();
			session.setAttribute("cart", CartService.cart);
			model.addAttribute("user", new User());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "cart";
	}

	@PostMapping("/cart-item")
	@ResponseBody
	// @RequestMapping(value = "/cart-item", method = RequestMethod.POST)
	public ResponseEntity<String> addItem(@RequestBody Map<String, String> rb, HttpSession session) {

		User user = ((User) session.getAttribute("user"));
		if (user == null) {
			return new ResponseEntity<>("{\"message\": \"Bad request\"}", HttpStatus.FORBIDDEN);
		}

		long itemId = Long.parseLong(rb.get("itemId"));
		int quantity = Integer.parseInt(rb.get("quantity"));
		Map cart = ((HashMap) session.getAttribute("cart"));
		CartService.cart = cart;
		CartService.addItemToCart((long) itemId, quantity);

		return new ResponseEntity<>("{\"message\": \"Success\"}", HttpStatus.OK);
	}

	@DeleteMapping("/cart-item")
	@ResponseBody
	public ResponseEntity<String> removeItem(@RequestBody Map<String, String> rb, Model model, HttpSession session) {

		User user = ((User) session.getAttribute("user"));
		if (user == null) {
			return new ResponseEntity<>("{\"message\": \"Bad request\"}", HttpStatus.FORBIDDEN);
		}
		long itemId = Long.parseLong(rb.get("itemId"));
		Map cart = ((HashMap) session.getAttribute("cart"));
		CartService.cart = cart;
		CartService.removeItemToCart(itemId);

		return new ResponseEntity<>("{\"message\": \"Success\"}", HttpStatus.OK);
	}
	
}
