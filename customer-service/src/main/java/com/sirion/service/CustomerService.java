package com.sirion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirion.entity.Customer;
import com.sirion.repo.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repo;
	
	public Customer addOrUpdateCustomer(Customer cust)  {
		return repo.saveAndFlush(cust);
	}
	
	public List<Customer> getAllCustomers(){
		return repo.findAll();
	}
	
	public Customer deleteCustomer(String username) {
		Optional<Customer> op = repo.findById(username);
		if(op.isPresent()) {
			repo.delete(op.get());
			return op.get();
		}else {
			return null;
		}
	}
	
	public Customer getCustomerById(String username) {
		Optional<Customer> op = repo.findById(username);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public Customer validateCustomer(String username,String password) {
		Customer cust = getCustomerById(username);
		System.out.println(cust);
		if(cust!=null && cust.getPassword().equals(password)) {
			return cust;
		}else {
			return null;
		}
	}
}
