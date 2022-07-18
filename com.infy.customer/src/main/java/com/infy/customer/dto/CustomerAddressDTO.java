package com.infy.customer.dto;

import com.infy.customer.entity.Customer;
import com.infy.customer.entity.CustomerAddress;

public class CustomerAddressDTO {
	private Integer addressId;
	private String address;
	private String city;
	private Integer pincode;
	private String state;
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
	
	public CustomerAddress convertDtoToEntity() {
		CustomerAddress customerAddress = new CustomerAddress();
		customerAddress.setAddressId(this.addressId);
		customerAddress.setAddress(this.address);
		customerAddress.setCity(this.city);;
		customerAddress.setState(this.state);
		customerAddress.setPincode(this.pincode);
		customerAddress.setCustomer(this.customer);
		return customerAddress;
	}
	
	
}
