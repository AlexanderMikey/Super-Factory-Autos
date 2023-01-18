package models.order;

import models.product.Product;
import srategy.PaymentSrategy;

public class Transaction {

	private Customer customer;
	private Product product;
	private PaymentSrategy payment;
	private String date;
	
	public Transaction(Customer customer, Product product, PaymentSrategy payment) {
		this.customer = customer;
		this.product = product;
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Product getProduct() {
		return product;
	}
	
	public PaymentSrategy getPayment() {
		return payment;
	}

	public String getDate() {
		return date;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setPayment(PaymentSrategy payment) {
		this.payment = payment;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
