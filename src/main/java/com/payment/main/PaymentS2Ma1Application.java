package com.payment.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentS2Ma1Application {

	public static void main(String[] args) {
		SpringApplication.run(PaymentS2Ma1Application.class, args);
	}

}
