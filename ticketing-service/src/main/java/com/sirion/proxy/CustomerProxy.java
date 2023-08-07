package com.sirion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sirion.bean.Customer;

@FeignClient(name = "exchange-service", url = "localhost:8085")
public interface CustomerProxy {
	@GetMapping("/username/{username}")
	public Customer getCustomer(@PathVariable String username);
}
