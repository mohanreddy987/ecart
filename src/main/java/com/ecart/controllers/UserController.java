package com.ecart.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecart.repository.models.OrderEntity;
import com.ecart.repository.models.User;
import com.ecart.service.CartService;
import com.ecart.service.OrderService;
import com.ecart.service.UserService;

import jakarta.servlet.http.HttpSession;

/**
 * Authorization Controller
 *
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	OrderService os;
	
	static final Logger log = 
	        LoggerFactory.getLogger(UserController.class);

	@GetMapping("/login")
	public String loadLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@GetMapping("/Logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:/welcome";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session, RedirectAttributes redirectAttributes) {

		if (session.getAttribute("email") != null) {
			return "redirect:/welcome";
		} else {
			User loggedInUser = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
			if (loggedInUser != null) {
				session.setAttribute("email", loggedInUser.getEmail());
				loggedInUser.setPassword(null);
				session.setAttribute("user", loggedInUser);
				session.setAttribute("cart", new CartService().cart);
				log.info("User with ID:"+ user.getUser_id()+" logged in successfully");
				return "redirect:/welcome";
			} else {
				redirectAttributes.addFlashAttribute("message", "Invalid Credentials.");
				System.out.println(redirectAttributes.getAttribute("message"));
				return "redirect:/login";
			}

		}
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.saveUser(user);

		return "redirect:/welcome";
	}

	@GetMapping("/profile")
	public String profile(HttpSession session, Model model) {
		User user = ((User) session.getAttribute("user"));
		if (user == null) {
			return "redirect:/welcome";
		}
		List<OrderEntity> orders = os.fetchOrderWithUserId(user.getUser_id());
		System.out.println((orders.size()));
		model.addAttribute("orders",orders);
		return "profile";
	}
}
