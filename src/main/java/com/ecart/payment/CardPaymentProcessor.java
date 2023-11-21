package com.ecart.payment;

/**
 * Class to process card payments
 */
public class CardPaymentProcessor implements Payment{

	String cardNumber;
	String nameOnCard;
	String expiryDate;
	String cvv;
	

	public CardPaymentProcessor(String cardNumber, String nameOnCard, String expiryDate, String cvv) {
		super();
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}


	@Override
	public void processPayment(double total) {
		// TODO Auto-generated method stub
		System.out.println("Processed payment of:"+ total+ " using credit card.");
		
	}

	
}
