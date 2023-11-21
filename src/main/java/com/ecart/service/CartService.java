package com.ecart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ecart.repository.ProductRepository;
import com.ecart.repository.models.ProductEntity;

/**
 * Class that provides the services that are related to cart.
 */
@Scope(value = "request")
@Service
public class CartService {

	public static ProductRepository pe;
	
	public static Map<Long, Map<String, String>> cart;

	public CartService() {
		super();
		this.cart = new HashMap<Long, Map<String, String>>();
	}
	

	public static double getCartvalue() {
		return 0;

	}

	public static void addItemToCart(Long productId, int quantity) {

		if (cart != null && cart.containsKey(productId)) {
			int crrQuantity = Integer.parseInt(cart.get(productId).get("quantity"));
			cart.get(productId).put("quantity", ""+(crrQuantity + quantity));
		} else {
			cart.put(productId, new HashMap<String, String>() {{
			    put("quantity", ""+quantity);
			}});
			
		}
	}

	public static void removeItemToCart(Long productId) {
		if (cart != null && cart.containsKey(productId)) {
			cart.remove(productId);
		}
	}

	public static void clearCart() {
		if (cart != null) {
			cart.clear();
		}
	}

	public static void loadCartProducts() {
	
		for( Entry<Long, Map<String, String>> entry : cart.entrySet() ) {
			
			Optional<ProductEntity> cartProduct = pe.findById(entry.getKey());
			int quantity = Integer.parseInt(entry.getValue().get("quantity"));
			double price = cartProduct.get().getPrice()* quantity;
			cart.get(entry.getKey()).put("name", cartProduct.get().getName());
			cart.get(entry.getKey()).put("price", ""+price);
			System.out.println(cartProduct.get().getName());
		}
	}
}
