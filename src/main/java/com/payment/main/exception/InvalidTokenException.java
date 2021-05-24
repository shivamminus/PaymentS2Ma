package com.payment.main.exception;




public class InvalidTokenException extends RuntimeException{
	
	public InvalidTokenException(String message) {
		super(message);
	}

}