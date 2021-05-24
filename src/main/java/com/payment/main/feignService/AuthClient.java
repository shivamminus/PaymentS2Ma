package com.payment.main.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.payment.main.dto.ValidatingDAO;

@FeignClient(name = "auth-client", url = "http://localhost:8081")
public interface AuthClient {

	@GetMapping(value = "/validate")
	public ValidatingDAO getsValidity(@RequestHeader(name = "Authorization", required = true) String token);

}
