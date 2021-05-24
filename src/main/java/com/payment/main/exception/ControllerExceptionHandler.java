package com.payment.main.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.payment.main.model.ErrorMessage;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = { InvalidFormatException.class, InvalidTokenException.class,
			CreditCardLimitExceed.class, InvalidCreditCardNumber.class, Exception.class })
	public ResponseEntity<ErrorMessage> resourceNotFoundException(Exception ex, WebRequest request) {
		final Date date = new Date();
		ErrorMessage message = new ErrorMessage(500, date, ex.getMessage());

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}