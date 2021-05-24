package com.payment.main.repository;

import com.payment.main.dto.PaymentDAO;

public interface PaymentRepository  {
	
	public PaymentDAO processPaymentService(String RequestId, Integer cardNumber, Integer creditLimit,
			Integer processingCharge);

}
