package com.payment.main.exception;

public class CreditCardLimitExceed extends RuntimeException {

	public CreditCardLimitExceed(String message) {
		super(message);
	}

}
