package com.sirion.bean;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Component
public class Address {
	@Id
	private int aId;
	private String city;
	private String country;
	
	@OneToMany
	@JsonIgnore
	private List<Customer> customers;

	public Address() {

	}

	public Address(int aId, String city, String country) {
		super();
		this.aId = aId;
		this.city = city;
		this.country = country;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
