package com.ecart.payment;

/**
 * Pojo for payment info
 */
public class PaymentInfo {

	String type;
	String paypalUserName;
	String paypalPassword;
	String cardNumber;
	String cardName;
	String expiry;
	String cvv;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPaypalUserName() {
		return paypalUserName;
	}
	public void setPaypalUserName(String paypalUserName) {
		this.paypalUserName = paypalUserName;
	}
	public String getPaypalPassword() {
		return paypalPassword;
	}
	public void setPaypalPassword(String paypalPassword) {
		this.paypalPassword = paypalPassword;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
}
