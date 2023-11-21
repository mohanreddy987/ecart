package com.ecart.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecart.pojo.Product;
import com.ecart.repository.models.User;
import com.ecart.service.CatalogService;

import jakarta.servlet.http.HttpSession;

/**
 * Home controller
 *
 */
@Controller
public class HomeController {

	@Autowired
	CatalogService catalogService;
	
    @GetMapping("/welcome")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model, HttpSession session) {

        User user =((User)session.getAttribute("user"));
        //System.out.print(user.getEmail());
        Map<String, List<Product>> cataLog= catalogService.loadCatalog();
        model.addAttribute("catalog",cataLog);
        return "hello";
    }

}
