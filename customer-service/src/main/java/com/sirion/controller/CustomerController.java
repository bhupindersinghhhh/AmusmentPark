package com.sirion.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirion.entity.Customer;
import com.sirion.exception.CustomerNotFound;
import com.sirion.exception.UserNotValidException;
import com.sirion.service.CustomerService;

@RestController
@RequestMapping("/user")
public class CustomerController {
	@Autowired
	private CustomerService cService;
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer cust = null;
		String error = null;
		try {
			cust = cService.addOrUpdateCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			error = e.getMessage();
		}
		if(cust!=null) {
			return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
		}else {
			return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public List<Customer> getAllUsers(){
		return cService.getAllCustomers();
	}
	
	@GetMapping("/username/{username}")
	public Customer getCustomerById(@PathVariable String username) throws CustomerNotFound {
		Customer cust = cService.getCustomerById(username);
		if(cust != null) {
			return cust;
		}else {
			throw new CustomerNotFound("Customer not found");
		}
	}
	
	@GetMapping("/validate")
	public ResponseEntity<Customer> validateCustomer(@RequestBody Map<String, String> arguments) throws UserNotValidException {
		System.out.println(arguments);
		System.out.println(arguments.get("username"));
		System.out.println(arguments.get("password"));
		Customer cus =  cService.validateCustomer(arguments.get("username"), arguments.get("password"));
		if(cus!=null) {
			return new ResponseEntity<Customer>(cus, HttpStatus.ACCEPTED);
		}else {
			throw new UserNotValidException("User not valid");
		}
	}
	
	@DeleteMapping("/username/{username}")
	public ResponseEntity<Customer> deleteUser(@PathVariable String username)throws CustomerNotFound {
		Customer cus = cService.deleteCustomer(username);
		if(cus!=null) {
			return new ResponseEntity<Customer>(cus, HttpStatus.OK);
		}else {
			throw new CustomerNotFound("Customer not found");
		}
	}
	
	@PutMapping
	public ResponseEntity<Customer> updateUser(@RequestBody Customer cust) throws CustomerNotFound {
		if(cust==null) {
			throw new CustomerNotFound("Customer body cannot be null");
		}
		Customer cus = cService.getCustomerById(cust.getUsername());
		Customer check = cService.addOrUpdateCustomer(cust);
		if(cus!=null) {
			return new ResponseEntity<Customer>(check,HttpStatus.OK);
		}else {
			throw new CustomerNotFound("Customer not found");
		}
	}
	
}
