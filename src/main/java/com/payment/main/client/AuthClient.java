package com.payment.main.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.payment.main.dao.ValidatingDAO;

@FeignClient(name = "AUTH-SERVICE", url = "http://localhost:9090/auth")
public interface AuthClient {

	@GetMapping(value = "/validate")
	public ValidatingDAO getsValidity(@RequestHeader(name = "Authorization", required = true) String token);

}
