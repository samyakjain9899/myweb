package com.sim.entity;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="UniqueIdNumber",unique = true)
	@Pattern(regexp="^[0-9]{16}$",message= "number should be 16 digits")
	private String uniqueId;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9]+@[a-z]+\\.[a-z]{2,3}$",message = "invalid email")
	private String emailAddress;
	@Size(min =1 , max=15 ,message = "Firstname/LastName should be maximum of 15 characters")
	private String firstName;
	@Size(min =1 , max=15 ,message = "Firstname/LastName should be maximum of 15 characters")
	private String lastName;
	private String idType;
	@Pattern(regexp = "[a-zA-Z\s]*" ,message = "State should not contain any special characters except space")
	private String state;
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private CustomerAddress address;
	@Column(nullable = false)
	private Integer simId;
	public String getuniqueId() {
		return uniqueId;
	}
	public CustomerAddress getAddress() {
		return address;
	}
	public void setAddress(CustomerAddress address) {
		this.address = address;
	}
	public Integer getSimId() {
		return simId;
	}
	public void setSimId(Integer simId) {
		this.simId = simId;
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
		return "Customer [id=" + id + ", uniqueId=" + uniqueId + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", idType=" + idType
				+ ", state=" + state + ", address=" + address + ", simId=" + simId + "]";
	}
	public Customer(String uniqueId, Date dateOfBirth, String emailAddress, String firstName,
			String lastName, String idType, String state,CustomerAddress address,Integer simId) {
		super();
		this.uniqueId = uniqueId;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idType = idType;
		this.state = state;
		this.address=address;
		this.simId=simId;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
