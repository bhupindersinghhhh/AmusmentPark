package com.sirion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirion.bean.Customer;
import com.sirion.bean.TicketBooking;

@Repository
public interface TIcketingRepo extends JpaRepository<TicketBooking, Integer> {
	List<TicketBooking> findByCustomer(Customer customer);
}
