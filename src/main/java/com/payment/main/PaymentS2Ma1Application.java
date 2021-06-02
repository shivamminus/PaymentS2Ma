package com.payment.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient
public class PaymentS2Ma1Application {
	
	private static Logger logger = LoggerFactory.getLogger(PaymentS2Ma1Application.class);

	public static void main(String[] args) {
		
		logger.info("Payment Application Started Succesfully");

//        System.setProperty("server.connection-timeout","120000");
		SpringApplication.run(PaymentS2Ma1Application.class, args);
	}

}
