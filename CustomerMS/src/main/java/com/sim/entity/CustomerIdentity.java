package com.sim.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CustomerIdentity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	@Column(name="UniqueIdNumber",unique = true)
	@Pattern(regexp="^[0-9]{16}$",message= "number should be 16 digits")
	private String uniqueId;
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfbirth;
    @NotNull
	@Size(min =1 , max=15 ,message = "Firstname/LastName should be maximum of 15 characters")
	private String firstName;
    @NotNull
	@Size(min =1 , max=15 ,message = "Firstname/LastName should be maximum of 15 characters")
	private String lastname;
	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9]+@[a-z]+\\.[a-z]{2,3}$",message = "invalid email")
	private String emailAddress;
	@NotNull
	@Pattern(regexp = "[a-zA-Z\s]*" ,message = "State should not contain any special characters except space")
	private String state;
	
	
	
	
	
	public String getUniqueIdNumber() {
		return uniqueId;
	}
	public void setUniqueIdNumber(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public Date getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(Date dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	@Override
	public String toString() {
		return "CustomerIdentity [uniqueIdNumber=" + uniqueId + ", dateOfbirth=" + dateOfbirth + ", firstName="
				+ firstName + ", lastname=" + lastname + ", emailAddress=" + emailAddress + ", state=" + state + "]";
	}
	public CustomerIdentity(String uniqueId,Date dateOfbirth, String firstName, String lastname,
			String emailAddress, String state) {
		super();
		this.uniqueId = uniqueId;
		this.dateOfbirth = dateOfbirth;
		this.firstName = firstName;
		this.lastname = lastname;
		this.emailAddress = emailAddress;
		this.state = state;
	}
	public CustomerIdentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
