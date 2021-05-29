package com.payment.main.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.payment.main.model.PaymentDetails;


@SpringBootTest
public class PaymentServiceTest {
	
	@Autowired
	PaymentService PaymentService;


	@Test
    @DisplayName("Checking if PaymentService is loading or not.")
   void PaymentServiceIsLoaded(){
        assertThat(PaymentService).isNotNull();    
    }
	@Test
	void testProcessPaymentService() {
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setCardNumber("123456789");
		paymentDetails.setRequestId("abc123");
		paymentDetails.setCreditLimit(500);
		paymentDetails.setProcessingCharge(100);
		
		
		 assertThat(PaymentService).isNotNull();
	}

}