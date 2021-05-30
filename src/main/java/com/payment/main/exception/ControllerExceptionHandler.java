package com.payment.main.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.payment.main.dao.ErrorMessage;
import com.payment.main.dao.PaymentDAO;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = { InvalidFormatException.class, InvalidTokenException.class,
			 InvalidCreditCardNumber.class })
	public ResponseEntity<ErrorMessage> resourceNotFoundException(Exception ex, WebRequest request) {
		final Date date = new Date();
		ErrorMessage message = new ErrorMessage(500, date, ex.getMessage());

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { CreditCardLimitExceed.class })
	public ResponseEntity<PaymentDAO> creditCardLimit(Exception ex, WebRequest request) {
		PaymentDAO paymentObj = new PaymentDAO(0.0);
		return new ResponseEntity<PaymentDAO>(paymentObj, HttpStatus.OK);
	}
	
	@ExceptionHandler(value = { SomethingWentWrong.class })
	public ResponseEntity<?> someThingWentWrong(Exception ex, WebRequest request) {
		/*
		 * final Date date = new Date(); ErrorMessage message = new ErrorMessage(500,
		 * date, ex.getMessage());
		 * 
		 * return new ResponseEntity<ErrorMessage>(message,
		 * HttpStatus.INTERNAL_SERVER_ERROR);
		 */
		PaymentDAO paymentObj = new PaymentDAO(0.0);
		return new ResponseEntity<PaymentDAO>(paymentObj, HttpStatus.OK);
	}

}