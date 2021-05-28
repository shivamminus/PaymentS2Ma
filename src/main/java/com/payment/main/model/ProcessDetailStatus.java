package com.payment.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProcessDetailStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payment_id;

	private String cardNumber;
	private int creditLimit;
	private int processingCharge;
	private String requestId;
	private String paymentStatus;

	public ProcessDetailStatus() {
		super();
	}

	public ProcessDetailStatus(String cardNumber, int creditLimit, int processingCharge, String requestId,
			String paymentStatus) {
		super();
		this.cardNumber = cardNumber;
		this.creditLimit = creditLimit;
		this.processingCharge = processingCharge;
		this.requestId = requestId;
		this.paymentStatus = paymentStatus;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
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

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "ProcessDetailStatus [payment_id=" + payment_id + ", cardNumber=" + cardNumber + ", creditLimit="
				+ creditLimit + ", processingCharge=" + processingCharge + ", requestId=" + requestId
				+ ", paymentStatus=" + paymentStatus + "]";
	}

}
