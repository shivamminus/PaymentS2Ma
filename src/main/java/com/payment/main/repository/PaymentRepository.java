package com.payment.main.repository;

import com.payment.main.dao.PaymentDAO;

public interface PaymentRepository  {
	
	public PaymentDAO processPaymentService(String cardNumber, int creditLimit, int processingCharge);

}
