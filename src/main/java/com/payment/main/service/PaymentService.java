package com.payment.main.service;

import org.springframework.stereotype.Service;

import com.payment.main.dao.PaymentDAO;
import com.payment.main.exception.CreditCardLimitExceed;
import com.payment.main.exception.InvalidCreditCardNumber;
import com.payment.main.exception.InvalidFormatException;
import com.payment.main.model.PaymentDetails;
import com.payment.main.repository.PaymentRepository;
import com.payment.main.util.Utilities;

@Service
public class PaymentService implements PaymentRepository {

	@Override
	public PaymentDAO processPaymentService(String cardNumber, int creditLimit, int processingCharge)
			throws InvalidFormatException {

		PaymentDetails paymentDetails = new PaymentDetails();
		Utilities util = new Utilities();
		int processed_amount = creditLimit - processingCharge;

		if (!util.validateCreditCard(cardNumber)) {
			throw new InvalidCreditCardNumber("Please Check Credit Card Detail");
		}

		if (processed_amount <= 0) {
			throw new CreditCardLimitExceed("Your Card Limit Amount exceeded");
		}
		try {
			
			paymentDetails.setCardNumber(cardNumber);
			// handle negative balance condition
			paymentDetails.setCreditLimit(processed_amount);
			paymentDetails.setProcessingCharge(processingCharge);

		} catch (Exception wrongInputException) {
			throw new InvalidFormatException(
					"Wrong type of the input provided...\n" + wrongInputException.getMessage());
		}

		return new PaymentDAO((double) paymentDetails.getCreditLimit());

	}

}
