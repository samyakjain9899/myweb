package com.infy.customer.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.infy.customer.dto.CustomerDTO;

@Entity
public class Customer {
	
	@Id
	private String uniqueIdNumber;
	private LocalDate dateOfBirth;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String state;
	private String idType;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerAddress_addressId", referencedColumnName = "addressId")
	private CustomerAddress customerAddress_addressId;
	private Integer simId;
	
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
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
	@Override
	public String toString() {
		return "Customer [uniqueIdNumber=" + uniqueIdNumber + ", dateOfBirth=" + dateOfBirth + ", firstName="
				+ firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", state=" + state
				+ ", idType=" + idType + ", customerAddress_addressId=" + customerAddress_addressId + ", simId=" + simId
				+ "]";
	}
	
	public CustomerDTO convertEntityToDto() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerAddress_addressId(this.customerAddress_addressId);
		customerDTO.setDateOfBirth(this.dateOfBirth);
		customerDTO.setEmailAddress(this.emailAddress);
		customerDTO.setFirstName(this.firstName);
		customerDTO.setIdType(this.idType);
		customerDTO.setLastName(this.lastName);
		customerDTO.setSimId(this.simId);
		customerDTO.setState(this.state);
		customerDTO.setUniqueIdNumber(this.uniqueIdNumber);
		return customerDTO;
	}

	
	
}
