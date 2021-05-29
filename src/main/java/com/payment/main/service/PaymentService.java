package com.payment.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.main.PaymentS2Ma1Application;
import com.payment.main.dao.PaymentDAO;
import com.payment.main.exception.CreditCardLimitExceed;
import com.payment.main.exception.InvalidCreditCardNumber;
import com.payment.main.exception.InvalidFormatException;
import com.payment.main.model.PaymentDetails;
import com.payment.main.model.ProcessDetailStatus;
import com.payment.main.repository.PaymentRepository;
import com.payment.main.repository.ProcessPaymentRepo;
import com.payment.main.util.Utilities;

@Service
public class PaymentService implements PaymentRepository {
	
	
	private static Logger logger = LoggerFactory.getLogger(PaymentS2Ma1Application.class);

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
	@Autowired
	ProcessPaymentRepo processPaymentRepo;

	@Override
	public PaymentDAO processPaymentService(String requestId, String cardNumber, int creditLimit, int processingCharge)
			throws InvalidFormatException {

		PaymentDetails paymentDetails = new PaymentDetails();
		Utilities util = new Utilities();

		int processed_amount = creditLimit - processingCharge;

		ProcessDetailStatus processDetailStaus = new ProcessDetailStatus(cardNumber, creditLimit, processingCharge,
				requestId, "pending");

		if (!util.validateCreditCard(cardNumber)) {
			processDetailStaus.setPaymentStatus("failed");
			processPaymentRepo.save(processDetailStaus);
			logger.warn("Please Check Credit Card Detail");
			throw new InvalidCreditCardNumber("Please Check Credit Card Detail");
		}

		if (processed_amount <= 0) {
			processDetailStaus.setPaymentStatus("failed");
			processPaymentRepo.save(processDetailStaus);
			logger.warn("Your Card Limit Amount exceeded");
			throw new CreditCardLimitExceed("Your Card Limit Amount exceeded");
		}

		try {
			
			paymentDetails.setCardNumber(cardNumber);
			// handle negative balance condition
			paymentDetails.setCreditLimit(processed_amount);
			paymentDetails.setProcessingCharge(processingCharge);
			processDetailStaus.setPaymentStatus("success");
			processPaymentRepo.save(processDetailStaus);
			logger.info("Process Detail saved Successfully");

		} catch (Exception wrongInputException) {
			processPaymentRepo.save(processDetailStaus);
			logger.error("Wrong type of the input provided...");
			throw new InvalidFormatException(
					"Wrong type of the input provided...\n" + wrongInputException.getMessage());
		}

		return new PaymentDAO((double) paymentDetails.getCreditLimit());

	}

}
