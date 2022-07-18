package com.infy.customer.dto;

public class SimDetailsDTO {
	private Integer simId;
	private String serviceNumber;
	private String simNumber;
	private String simStatus;
	private SimOffersDTO offers;
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
	public SimOffersDTO getOffers() {
		return offers;
	}
	public void setOffers(SimOffersDTO offers) {
		this.offers = offers;
	}
	public String getCustomerUniqueIdNumber() {
		return customerUniqueIdNumber;
	}
	public void setCustomerUniqueIdNumber(String customerUniqueIdNumber) {
		this.customerUniqueIdNumber = customerUniqueIdNumber;
	}
	
}
