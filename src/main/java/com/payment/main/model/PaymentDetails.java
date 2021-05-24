package com.payment.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentDetails {

	@Id
	@Column(unique = true, nullable = false)
	private String cardNumber;
	private int creditLimit;
	private int processingCharge;

	public PaymentDetails() {
		super();
	}

	public PaymentDetails(String cardNumber, int creditLimit, int processingCharge) {
		super();
		this.cardNumber = cardNumber;
		this.creditLimit = creditLimit;
		this.processingCharge = processingCharge;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

	public int getProcessingCharge() {
		return processingCharge;
	}

	public void setProcessingCharge(int processingCharge) {
		this.processingCharge = processingCharge;
	}

}
