package com.ecart.pojo;

import com.ecart.payment.PaymentInfo;
import com.ecart.pojo.AddressInfo;

public class OrderSubmitForm {

	private AddressInfo address;
	private PaymentInfo payment;
	private double total;

	public OrderSubmitForm(AddressInfo address, PaymentInfo payment, double total) {
		super();
		this.address = address;
		this.payment = payment;
		this.total = total;
	}

	public AddressInfo getAddress() {
		return address;
	}

	public void setAddress(AddressInfo address) {
		this.address = address;
	}

	public PaymentInfo getPayment() {
		return payment;
	}

	public void setPayment(PaymentInfo payment) {
		this.payment = payment;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
