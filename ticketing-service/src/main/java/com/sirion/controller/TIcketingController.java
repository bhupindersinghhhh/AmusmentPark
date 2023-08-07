package com.sirion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirion.bean.Customer;
import com.sirion.bean.TicketBooking;
import com.sirion.proxy.CustomerProxy;
import com.sirion.service.TicketBookingService;

@RestController
@RequestMapping("/ticket")
public class TIcketingController {
	
	@Autowired
	private TicketBookingService tService;
	
	@Autowired(required = false)
	private CustomerProxy proxy;
	
	@PostMapping
	public TicketBooking addTicket(@RequestBody TicketBooking ticket) {
		if(ticket==null) {
			return null;
		}
		return tService.insertTicketBooking(ticket);
	}
	
	@PutMapping
	public TicketBooking updateTickBooking(@RequestBody TicketBooking ticket) {
		if(ticket==null) {
			return null;
		}
		return tService.updateTicketBooking(ticket);
	}
	@DeleteMapping
	public TicketBooking deleTicketBooking(@RequestBody TicketBooking ticket) {
		if(ticket==null) {
			return null;
		}
		return tService.deleteTicketBooking(ticket.getTicketBookingId());
	}
	
	@GetMapping("/username/{username}")
	public List<TicketBooking> getAllCustomerTickets(@PathVariable String username){
		Customer cus = proxy.getCustomer(username);
		if(cus==null) {
			return null;
		}else {
			return tService.viewAllTicketsCustomer(cus);
		}
	}
	
	@GetMapping("/bill/username/{username}")
	public double getBill(@PathVariable String username){
		Customer cus = proxy.getCustomer(username);
		if(cus==null) {
			return 0;
		}else {
			return tService.calculateBill(cus);
		}
	}
	
	
}
