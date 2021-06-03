package com.payment.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payment.main.PaymentS2Ma1Application;
import com.payment.main.client.AuthClient;
import com.payment.main.dao.PaymentDAO;
import com.payment.main.exception.InvalidTokenException;
import com.payment.main.exception.SomethingWentWrong;
import com.payment.main.service.PaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
	
	private static Logger logger = LoggerFactory.getLogger(PaymentS2Ma1Application.class);

	@Autowired
	private PaymentService paymentServiceImpl;
	@Autowired
	private AuthClient authClient;

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
	@GetMapping(path = "/processpayment", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> paymentDetails(@RequestParam String requestId, @RequestParam String cardNumber,
			@RequestParam int creditLimit, @RequestParam int processingCharge,
			@RequestHeader(name = "Authorization", required = true) String token) throws InvalidTokenException {

		if (!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid...");
		}

		try {
			return new ResponseEntity<>(
					paymentServiceImpl.processPaymentService(requestId, cardNumber, creditLimit, processingCharge),
					HttpStatus.OK);

		} catch (Exception serverError) {
			logger.error(serverError.getMessage());
			throw new SomethingWentWrong("Sorry Something went wrong, try again later");

		}

	}
	
}