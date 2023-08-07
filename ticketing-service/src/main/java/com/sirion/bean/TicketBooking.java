package com.sirion.bean;

import java.time.LocalDateTime;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class TicketBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketBookingId;
	@Autowired
	@ManyToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="username")
	private Customer customer;
	@Autowired
	@OneToOne
	private Activity activity;
	private LocalDateTime dateTime;

	public TicketBooking(Customer customer, Activity activity, LocalDateTime dateTime) {
		super();
		this.customer = customer;
		this.activity = activity;
		this.dateTime = dateTime;
	}

	public int getTicketBookingId() {
		return ticketBookingId;
	}

	public void setTicketBookingId(int ticketBookingId) {
		this.ticketBookingId = ticketBookingId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}