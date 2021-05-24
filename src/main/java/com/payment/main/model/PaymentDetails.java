package com.payment.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentDetails {

	@Id
	private int id;
	@Column(nullable = false, unique = true)
	private String requestId;

	@Column(unique = true, nullable = false)
	private Integer cardNumber;
	private int creditLimit;
	private int processingCharge;

	public PaymentDetails() {
		super();
	}

	public PaymentDetails(String requestId, Integer cardNumber, int creditLimit, int processingCharge) {
		super();
		this.requestId = requestId;
		this.cardNumber = cardNumber;
		this.creditLimit = creditLimit;
		this.processingCharge = processingCharge;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
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

	@Override
	public String toString() {
		return "PaymentDetails [requestId=" + requestId + ", cardNumber=" + cardNumber + ", creditLimit=" + creditLimit
				+ ", processingCharge=" + processingCharge + "]";
	}

}
