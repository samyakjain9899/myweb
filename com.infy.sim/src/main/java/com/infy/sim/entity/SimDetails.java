package com.infy.sim.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infy.sim.dto.SimDetailsDTO;
@Entity
@JsonIgnoreProperties(value = {"offers", "customer"})
public class SimDetails {
	
	@Id
	private Integer simId;
	private String serviceNumber;
	private String simNumber;
	private String simStatus;
	@OneToOne(mappedBy="simDetails")
	private SimOffers offers;
	private String customerUniqueIdNumber;
	
	public Integer getSimId() {
		return simId;
	}
	public void setSimId(Integer simId) {
		this.simId = simId;
	}
	public String getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public String getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}
	public String getSimStatus() {
		return simStatus;
	}
	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}
	
	public SimOffers getOffers() {
		return offers;
	}
	public void setOffers(SimOffers offers) {
		this.offers = offers;
	}
	public String getCustomerUniqueIdNumber() {
		return customerUniqueIdNumber;
	}
	public void setCustomerUniqueIdNumber(String customerUniqueIdNumber) {
		this.customerUniqueIdNumber = customerUniqueIdNumber;
	}
	
	@Override
	public String toString() {
		return "SimDetails [simId=" + simId + ", serviceNumber=" + serviceNumber + ", simNumber=" + simNumber
				+ ", simStatus=" + simStatus + ", offers=" + offers + ", customer=" + customerUniqueIdNumber + "]";
	}
	
	
	public SimDetailsDTO convertEntityToDto() {
		SimDetailsDTO simDetailsDTO = new SimDetailsDTO();
		simDetailsDTO.setCustomerUniqueIdNumber(this.customerUniqueIdNumber);
		simDetailsDTO.setOffers(this.offers);
		simDetailsDTO.setServiceNumber(this.serviceNumber);
		simDetailsDTO.setSimId(this.simId);
		simDetailsDTO.setSimNumber(this.simNumber);
		simDetailsDTO.setSimStatus(this.simStatus);
		return simDetailsDTO;
	}
	
	

}
