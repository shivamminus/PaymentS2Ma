package com.payment.main.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.payment.main.client.AuthClient;
import com.payment.main.dao.PaymentDAO;
import com.payment.main.dao.ValidatingDAO;
import com.payment.main.exception.InvalidTokenException;
import com.payment.main.exception.SomethingWentWrong;
import com.payment.main.service.PaymentService;




@SpringBootTest
public class PaymentControllerTest {

	@InjectMocks
	PaymentController  paymentController;
	
	@Mock
	AuthClient authClient;
	
	@Mock
	PaymentService paymentServiceImpl;
	
	@Test
    @DisplayName("Checking if [PaymentController] is loading or not.")
     void paymentControllerIsLoaded(){
        assertThat(paymentController).isNotNull();    
    }
	
	@Test
    @DisplayName("Checking if [PaymentController] is loading or not.")
     void paymentControllerIsLoadedFalse(){
        assertThat(paymentController).isNotNull();    
    }
	
	/*
	 * @Test void testConnection() {
	 * when(paymentController.healthCheck()).thenReturn(new ResponseEntity<>("OK",
	 * HttpStatus.OK)); assertEquals("OK",
	 * paymentController.healthCheck().getBody()); }
	 */
	
	
	
	
	@Test
	void testProcessPayment() throws InvalidTokenException {
		String token = "token";
		when(authClient.getsValidity(token)).thenReturn(new ValidatingDAO(true));
		when(paymentServiceImpl.processPaymentService("kaspdko-aokpoqq-iuhdq", "4012887898341881", 100000, 500)).thenReturn(new PaymentDAO(9500.0));
		assertEquals(200, paymentController.paymentDetails("kaspdko-aokpoqq-iuhdq", "4012887898341881", 100000, 500, "token").getStatusCodeValue());
	}
	
	
	
	@Test
	void testProcessPaymentBadRequest() throws InvalidTokenException {
		try {
			
			String token = "token";
			when(authClient.getsValidity(token)).thenReturn(new ValidatingDAO(false));
			when(paymentServiceImpl.processPaymentService("kaspdko-aokpoqq-iuhdq", "4012887898341881", 100000, 500)).thenReturn(new PaymentDAO(9500.0));
		} catch (InvalidTokenException invalid) {
			assertEquals(400, paymentController.paymentDetails("kaspdko-aokpoqq-iuhdq", "4012887898341881", 100000, 500, "token").getStatusCodeValue());
			
		}
	}
	

	/*
	 * Test for FORBIDDEN completeProcessing
	 */
	@Test
	void testProcessPaymentForbiddenRequest() throws InvalidTokenException {
		String token = "token";
		when(authClient.getsValidity(token)).thenReturn(new ValidatingDAO(true));
		when(paymentServiceImpl.processPaymentService("kaspdko-aokpoqq-iuhdq", "4012887898341881", 100, 500000)).thenThrow(SomethingWentWrong.class);
		assertEquals(200, paymentController.paymentDetails("kaspdko-aokpoqq-iuhdq", "4012887898341881", 100000, 500, "token").getStatusCodeValue());
	}
	

}
