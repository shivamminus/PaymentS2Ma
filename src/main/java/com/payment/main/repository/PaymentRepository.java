package com.payment.main.repository;

import com.payment.main.dao.PaymentDAO;

public interface PaymentRepository  {
	/*
	 * This Function will process the payment
	 * 
	 * @params String cardNumber
	 * 
	 * @params int creditLimit
	 * 
	 * @params int processingCharge
	 * 
	 * @return PaymentDAO obj
	 * 
	 */
	public PaymentDAO processPaymentService(String requestId, String cardNumber, int creditLimit, int processingCharge);
	

}