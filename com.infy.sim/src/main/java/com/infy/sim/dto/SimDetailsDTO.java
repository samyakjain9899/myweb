package com.infy.sim.dto;

import com.infy.sim.entity.SimDetails;
import com.infy.sim.entity.SimOffers;

public class SimDetailsDTO {
	private Integer simId;
	private String serviceNumber;
	private String simNumber;
	private String simStatus;
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
	
	public SimDetails convertDtoToEntity() {
		SimDetails simDetails = new SimDetails();
		simDetails.setCustomerUniqueIdNumber(this.customerUniqueIdNumber);
		simDetails.setOffers(this.offers);
		simDetails.setServiceNumber(this.serviceNumber);
		simDetails.setSimId(this.simId);
		simDetails.setSimNumber(this.simNumber);
		simDetails.setSimStatus(this.simStatus);
		return simDetails;
	}
	
	
}
