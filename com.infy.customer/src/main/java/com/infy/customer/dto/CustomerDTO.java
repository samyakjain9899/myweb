package com.infy.customer.dto;

import java.time.LocalDate;

import com.infy.customer.entity.Customer;
import com.infy.customer.entity.CustomerAddress;

public class CustomerDTO {

	private String uniqueIdNumber;
	private LocalDate dateOfBirth;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String state;
	private String idType;
	private CustomerAddress customerAddress_addressId;
	private Integer simId;
	public String getUniqueIdNumber() {
		return uniqueIdNumber;
	}
	public void setUniqueIdNumber(String uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public CustomerAddress getCustomerAddress_addressId() {
		return customerAddress_addressId;
	}
	public void setCustomerAddress_addressId(CustomerAddress customerAddress_addressId) {
		this.customerAddress_addressId = customerAddress_addressId;
	}
	public Integer getSimId() {
		return simId;
	}
	public void setSimId(Integer simId) {
		this.simId = simId;
	}
	
	public Customer convertDtoToEntity() {
		Customer customer = new Customer();
		customer.setUniqueIdNumber(this.uniqueIdNumber);
		customer.setDateOfBirth(this.dateOfBirth);
		customer.setEmailAddress(this.emailAddress);
		customer.setFirstName(this.firstName);
		customer.setIdType(this.idType);
		customer.setLastName(this.lastName);
		customer.setState(this.state);
		customer.setCustomerAddress_addressId(this.customerAddress_addressId);
		customer.setSimId(this.simId);
		return customer;
	}
}
