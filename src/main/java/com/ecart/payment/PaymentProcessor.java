package com.ecart.payment;
/**
 * Payment processor class which is exposed out from package
 * it is responsible for creating the different types of payment methods
 */
public class PaymentProcessor {

	public Payment getPaymnetProcessor(String type, PaymentInfo info) {

		switch (type.toLowerCase()) {
		case "paypal": {

			Payment paypal = new Paypal(info.getPaypalUserName(), info.getPaypalPassword());
			return paypal;
		}
		case "card": {
			Payment card = new CardPaymentProcessor(info.getCardName(),info.getCardName(),
					info.getExpiry(), info.getCvv());
			return card;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type.toLowerCase());
		}

	}
}
