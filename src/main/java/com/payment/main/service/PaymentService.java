package com.payment.main.service;

import org.springframework.stereotype.Service;

import com.payment.main.dto.PaymentDAO;
import com.payment.main.exception.InvalidFormatException;
import com.payment.main.model.PaymentDetails;
import com.payment.main.repository.PaymentRepository;

@Service
public class PaymentService implements PaymentRepository {

	@Override
	public PaymentDAO processPaymentService(String RequestId, Integer cardNumber, Integer creditLimit,
			Integer processingCharge) throws InvalidFormatException {

		PaymentDetails paymentDetails = new PaymentDetails();

		try {
			paymentDetails.setCardNumber(cardNumber);
			paymentDetails.setRequestId(RequestId);
			// handle negative balance condition
			paymentDetails.setCreditLimit(creditLimit - processingCharge);
			paymentDetails.setProcessingCharge(processingCharge);

		} catch (Exception wrongInputException) {
			throw new InvalidFormatException(
					"Wrong type of the input provided...\n" + wrongInputException.getMessage());
		}

		return new PaymentDAO((double) paymentDetails.getCreditLimit());

	}

}
