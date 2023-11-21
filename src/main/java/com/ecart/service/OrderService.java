package com.ecart.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.controllers.UserController;
import com.ecart.order.Order;
import com.ecart.pojo.OrderSubmitForm;
import com.ecart.repository.OrderRepository;
import com.ecart.repository.ProductRepository;
import com.ecart.repository.models.OrderEntity;
import com.ecart.repository.models.User;
/**
 * Class that provides the services that are related to order.
 */
@Service
public class OrderService {

	@Autowired
	public ProductRepository pe;
	@Autowired
	OrderRepository or;
	static final Logger log = 
	        LoggerFactory.getLogger(OrderService.class);
	public void placeOrder(Map cart, OrderSubmitForm orderInfo, User loggedInUser) throws Exception{
		
		Double total = this.calculateTotal(cart);
		
		Order order = new Order.Orderbuilder().newInstance()
				.setCart(cart).setOrderInfo(orderInfo).setPe(pe).setOr(or)
				.setLoggedInUser(loggedInUser)
				.validateAndBuildOrder()
				.processPayment().build();
		
		order.saveOrder();
		log.info("New Order Created");
				
	}
	
	public List<OrderEntity> fetchOrderWithUserId(Long userId){
		return or.getOrdersByCustomerId(userId);
	}
	
	public double calculateTotal(Map<Long, Map<String, String>> cart) {
		double total = 0.00;
		for(Entry<Long, Map<String, String>> entry : cart.entrySet()) {
			total+= Double.parseDouble(entry.getValue().get("price"));
			
		}
		return total;
	}
}
