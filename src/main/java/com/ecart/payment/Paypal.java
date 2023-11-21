package com.ecart.payment;

/**
 * Class to Paypal payments
 */
public class Paypal implements Payment{

	String username;
	String password;
	
	public Paypal(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public void processPayment(double price) {
		// TODO Auto-generated method stub
		
	}

	
}
