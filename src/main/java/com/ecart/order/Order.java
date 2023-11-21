package com.ecart.order;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import com.ecart.payment.Payment;
import com.ecart.payment.PaymentProcessor;
import com.ecart.pojo.OrderSubmitForm;
import com.ecart.repository.OrderRepository;
import com.ecart.repository.ProductRepository;
import com.ecart.repository.models.OrderEntity;
import com.ecart.repository.models.ProductEntity;
import com.ecart.repository.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.StreamReadConstraints.Builder;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Order {

	Orderbuilder builder;

	public Order(Orderbuilder builder) {
		this.builder = builder;
	}

	public void saveOrder() throws JsonProcessingException {

		OrderEntity orderEntitty = new OrderEntity();

		ObjectMapper objectMapper = new ObjectMapper();
		String orderCart = objectMapper.writeValueAsString(builder.getCart());
		orderEntitty.setOrderItemsJson(orderCart);
		orderEntitty.setOrderDate(new Timestamp(System.currentTimeMillis()));
		orderEntitty.setOrderAddress(objectMapper.writeValueAsString(builder.getOrderInfo().getAddress()));
		orderEntitty.setStatus("In process");
		orderEntitty.setCustomerId(builder.getLoggedInUser().getUser_id());
		orderEntitty.setTotalAmount(new BigDecimal(builder.orderInfo.getTotal()));
		builder.getOr().save(orderEntitty);
		System.out.println("Order Saved Successfully");
	}

	public static class Orderbuilder {

		private Map<Long, Map<String, String>> cart;
		private OrderSubmitForm orderInfo;
		public ProductRepository pe;
		public OrderRepository or;
		public User loggedInUser;
		

		public User getLoggedInUser() {
			return loggedInUser;
		}

		public Orderbuilder setLoggedInUser(User loggedInUser) {
			this.loggedInUser = loggedInUser;
			return this;
		}

		public OrderRepository getOr() {
			return or;
		}

		public Orderbuilder setOr(OrderRepository or) {
			this.or = or;
			return this;
		}

		public ProductRepository getPe() {
			return pe;
		}

		public Orderbuilder setPe(ProductRepository pe) {
			this.pe = pe;
			return this;
		}

		public Map getCart() {
			return cart;
		}

		public Orderbuilder setCart(Map cart) {
			this.cart = cart;
			return this;
		}

		public OrderSubmitForm getOrderInfo() {
			return orderInfo;
		}

		public Orderbuilder setOrderInfo(OrderSubmitForm info) {
			this.orderInfo = info;
			return this;
		}

		public static Orderbuilder newInstance() {
			return new Orderbuilder();
		}

		public Orderbuilder validateAndBuildOrder() throws Exception {
			for (Entry<Long, Map<String, String>> entry : this.cart.entrySet()) {
				Optional<ProductEntity> product = pe.findById(entry.getKey());
				if (product.get().getQuantityInStock() < Long.parseLong(entry.getValue().get("quantity"))) {
					throw new Exception(product.get().getName() + " out of stock");
				}
			}

			return this;
		}

		/**
		 * This method is used to process the payment using the payment package.
		 * 
		 * @return
		 * @throws Exception
		 */
		public Orderbuilder processPayment() throws Exception {
			Payment processor = new PaymentProcessor().getPaymnetProcessor("card", this.orderInfo.getPayment());
			processor.processPayment(this.orderInfo.getTotal());
			return this;
		}

		public Order build() {
			return new Order(this);
		}
	}
}
