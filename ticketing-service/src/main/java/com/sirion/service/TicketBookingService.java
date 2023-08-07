package com.sirion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirion.bean.Customer;
import com.sirion.bean.TicketBooking;
import com.sirion.repo.TIcketingRepo;

@Service
public class TicketBookingService implements ITicketBookingService {
	@Autowired
	private TIcketingRepo repo;

	@Override
	public TicketBooking insertTicketBooking(TicketBooking ticketBooking) {
		if (ticketBooking == null) {
			return null;
		}
		return repo.saveAndFlush(ticketBooking);
	}

	@Override
	public TicketBooking updateTicketBooking(TicketBooking ticketBooking) {
		if (ticketBooking == null) {
			return null;
		}
		return repo.saveAndFlush(ticketBooking);
		
	}

	@Override
	public TicketBooking deleteTicketBooking(int ticketId) {
		Optional<TicketBooking> op = repo.findById(ticketId);
		if(op.isPresent()) {
			repo.delete(op.get());
			return op.get();
		}else {
			return null;
		}
	}

	@Override
	public List<TicketBooking> viewAllTicketsCustomer(Customer customer) {
		return repo.findByCustomer(customer);
	}

	@Override
	public double calculateBill(Customer customer) {
		double bill = 0;
		List<TicketBooking> lis = repo.findByCustomer(customer);
		for(TicketBooking ele:lis) {
			bill += ele.getActivity().getCharges();
		}
		return bill;
	}

}
