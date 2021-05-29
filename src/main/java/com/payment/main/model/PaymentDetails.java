package com.payment.main.model;

public class PaymentDetails {
	
	private String requestId;

	private String cardNumber;
	private int creditLimit;
	private int processingCharge;

	public PaymentDetails() {
		super();
	}

	public PaymentDetails(String requestId, String cardNumber, int creditLimit, int processingCharge) {
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
