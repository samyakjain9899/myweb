package com.sim.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;


import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Configuration
@Entity

public class CustomerAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	@Pattern(regexp = "^[a-zA-Z0-9]{1,25}$",
		    message = "Address should be maximum of 25-characters")
	private String address;
	@Pattern(regexp = "[a-zA-Z\s]*" ,message = "City should not contain any special characters except space")
	private String city;
	@Pattern(regexp = "^[0-9]{6}$",
		    message = "Pin should be 6 digit number")
	private String pincode;
	@Pattern(regexp = "[a-zA-Z\s]*" ,message = "State should not contain any special characters except space")
	private String state;
	@JsonIgnore
	@OneToOne(mappedBy = "address"  ,cascade= CascadeType.ALL)
	private Customer customer;
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "CustomerAddress [addressId=" + addressId + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", state=" + state + "]";
	}
	public CustomerAddress( String address, String city, String pincode, String state) {
		super();
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}
	public CustomerAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
