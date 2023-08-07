package com.sirion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirion.entity.Address;
import com.sirion.repo.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository repo;
	
	public List<Address> addAddress(Address address) {
		repo.saveAndFlush(address);
		return repo.findAll();
	}
	
	public List<Address> getAllAddresses(){
		return repo.findAll();
	}
}
