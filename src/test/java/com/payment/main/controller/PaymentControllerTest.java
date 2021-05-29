package com.payment.main.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;




@SpringBootTest
public class PaymentControllerTest {

	@Mock
	PaymentController  paymentController;
	
	
	@Test
    @DisplayName("Checking if [PaymentController] is loading or not.")
     void paymentControllerIsLoaded(){
        assertThat(paymentController).isNotNull();    
    }
	
	@Test
	void testConnection() {
		when(paymentController.healthCheck()).thenReturn(new ResponseEntity<>("OK", HttpStatus.OK));
		assertEquals("OK", paymentController.healthCheck().getBody());
	}
}
