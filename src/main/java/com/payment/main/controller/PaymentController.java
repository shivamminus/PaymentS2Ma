package com.payment.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.payment.main.dto.PaymentDAO;
import com.payment.main.exception.InvalidTokenException;
import com.payment.main.feignService.AuthClient;
import com.payment.main.service.PaymentService;

import feign.FeignException;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentServiceImpl;
	@Autowired
	private AuthClient authClient;

	@PostMapping(path = "/processpayment/{requestId}/{cardNumber}/{creditLimit}/{processingCharge}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentDAO> paymentDetails(@PathVariable String requestId, @PathVariable int cardNumber,
			@PathVariable int creditLimit, @PathVariable int processingCharge,
			@RequestHeader(name = "Authorization", required = true) String token) throws InvalidTokenException {

		try {
			if (!authClient.getsValidity(token).isValidStatus()) {

				throw new InvalidTokenException("Token is either expired or invalid...");
			}

		} catch (FeignException e) {
			throw new InvalidTokenException("Token is either expired or invalid...");

		}

		try {
			return new ResponseEntity<>(
					paymentServiceImpl.processPaymentService(requestId, cardNumber, creditLimit, processingCharge),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(
					paymentServiceImpl.processPaymentService(requestId, cardNumber, creditLimit, processingCharge),
					HttpStatus.FORBIDDEN);

		}

	}

	@GetMapping(path = "/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

}