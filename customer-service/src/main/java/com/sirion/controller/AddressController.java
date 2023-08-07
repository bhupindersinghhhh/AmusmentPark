package com.sirion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirion.entity.Address;
import com.sirion.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService aService;
	
	@PostMapping
	private void addAddress(Address address) {
		aService.addAddress(address);
	}
	
	@GetMapping
	private List<Address> getAddresses() {
		return aService.getAllAddresses();
	}
	
	
	
}
