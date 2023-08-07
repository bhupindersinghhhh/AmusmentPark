package com.sirion.service;

import java.util.List;

import com.sirion.bean.Customer;
import com.sirion.bean.TicketBooking;


public interface ITicketBookingService {
	public TicketBooking insertTicketBooking(TicketBooking ticketBooking);
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking);
	public TicketBooking deleteTicketBooking(int ticketId);
	public List<TicketBooking> viewAllTicketsCustomer(Customer customer);
	public double calculateBill(Customer customer);
}