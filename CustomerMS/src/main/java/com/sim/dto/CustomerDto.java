package com.sim.dto;


import java.util.Date;


import com.sim.entity.Customer;
import com.sim.entity.CustomerAddress;




public class CustomerDto   {
	private String uniqueId;
	private Date dateOfBirth;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String idType;
	private String state;
	
	private CustomerAddress address;
	private SimDetailsDto details;
	
	public CustomerDto(String uniqueId, Date dateOfBirth, String emailAddress, String firstName, String lastName,
			String idType, String state, CustomerAddress address, SimDetailsDto details) {
		super();
		this.uniqueId = uniqueId;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idType = idType;
		this.state = state;
		this.address = address;
		this.details = details;
	}
	public CustomerAddress getAddress() {
		return address;
	}
	public void setAddress(CustomerAddress custaddDTO) {
		this.address = custaddDTO;
	}
	public SimDetailsDto getDetails() {
		return details;
	}
	public void setDetails(SimDetailsDto details) {
		this.details = details;
	}
	public String getuniqueId() {
		return uniqueId;
	}
	public void setuniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Customer [uniqueId=" + uniqueId + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", idType=" + idType
				+ ", state=" + state + "]";
	}
	
	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Converts Entity into DTO
	public static CustomerDto valueOf(Customer cust) {
		CustomerDto custDTO = new CustomerDto();
		System.out.println(cust.getAddress());
	    custDTO.setAddress(cust.getAddress());
		custDTO.setDateOfBirth(cust.getDateOfBirth());
		custDTO.setEmailAddress(cust.getEmailAddress());
		custDTO.setFirstName(cust.getFirstName());
		custDTO.setLastName(cust.getLastName());
		custDTO.setState(cust.getState());
		custDTO.setuniqueId(cust.getuniqueId());
		custDTO.setIdType(cust.getIdType());
		SimDetailsDto simDTO = new SimDetailsDto();
		simDTO.setSimId(cust.getSimId());
		custDTO.setDetails(simDTO);
		
		return custDTO;
	}

	// Converts DTO into Entity
	public Customer createEntity() {
		Customer cust = new Customer();
		cust.setAddress(this.getAddress());
		cust.setDateOfBirth(this.getDateOfBirth());
		cust.setEmailAddress(this.getEmailAddress());
		cust.setFirstName(this.getFirstName());
		cust.setIdType(this.getIdType());
		cust.setLastName(this.getLastName());
		cust.setSimId(this.getDetails().getSimId());
		cust.setState(this.getState());
		cust.setuniqueId(this.getuniqueId());
		return cust;
	}


}
