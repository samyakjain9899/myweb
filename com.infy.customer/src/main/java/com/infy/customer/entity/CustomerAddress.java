package com.infy.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infy.customer.dto.CustomerAddressDTO;

@Entity
@JsonIgnoreProperties(value = {"customer"})
public class CustomerAddress {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Integer addressId;
	private String address;
	private String city;
	private Integer pincode;
	private String state;
	@OneToOne(mappedBy="customerAddress_addressId")
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
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerAddress [addressId=" + addressId + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", state=" + state + ", customer=" + customer + "]";
	}
	
	public CustomerAddressDTO convertEntityToDto() {
		CustomerAddressDTO customerAddressDTO = new CustomerAddressDTO();
		customerAddressDTO.setAddress(this.address);
		customerAddressDTO.setAddressId(this.addressId);
		customerAddressDTO.setCity(this.city);
		customerAddressDTO.setCustomer(this.customer);
		customerAddressDTO.setPincode(this.pincode);
		customerAddressDTO.setState(this.state);
		return customerAddressDTO;
	}
	
	
	
}
