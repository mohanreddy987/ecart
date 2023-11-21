package com.ecart.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecart.payment.PaymentInfo;
import com.ecart.pojo.AddressInfo;
import com.ecart.pojo.Cart;
import com.ecart.pojo.OrderSubmitForm;
import com.ecart.repository.ProductRepository;
import com.ecart.repository.models.User;
import com.ecart.service.CartService;
import com.ecart.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	@Autowired
	public ProductRepository pe;

	@Autowired
	public OrderService os;

	static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@GetMapping("/place-order")
	public String placeOrder(HttpSession session, Model model) {

		User user = ((User) session.getAttribute("user"));
		if (user == null) {
			return "redirect:/welcome";
		}
		Map cart = ((HashMap) session.getAttribute("cart"));
		double total = os.calculateTotal(cart);
		model.addAttribute("orderSubmit", new OrderSubmitForm(new AddressInfo(), new PaymentInfo(), total));
		return "order";
	}

	@PostMapping("/place-order")
	public String submitOrder(HttpSession session, @ModelAttribute OrderSubmitForm orderForm,
			RedirectAttributes redirectAttributes) {

		User user = ((User) session.getAttribute("user"));
		if (user == null) {
			return "redirect:/welcome";
		}
		try {
			Map cart = ((HashMap) session.getAttribute("cart"));

			os.placeOrder(cart, orderForm, user);
			log.info("Order place Successfully by user with ID:" + user.getUser_id());
			session.setAttribute("cart", new CartService().cart);
			redirectAttributes.addFlashAttribute("message", "Order placed successfully." + "Order can viewd in my profile page");

		} catch (Exception e) {
			log.error(e.getMessage());
			System.out.println(e.getMessage());
		}
		return "redirect:/welcome";
	}
}
