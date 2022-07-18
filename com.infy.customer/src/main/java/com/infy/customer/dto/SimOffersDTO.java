package com.infy.customer.dto;

public class SimOffersDTO {
	private Integer offerId;
	private Integer callQty;
	private Integer cost;
	private Integer dataQty;
	private Integer duration;
	private String offerName;
	private SimDetailsDTO simDetails;
	public Integer getOfferId() {
		return offerId;
	}
	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}
	public Integer getCallQty() {
		return callQty;
	}
	public void setCallQty(Integer callQty) {
		this.callQty = callQty;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer getDataQty() {
		return dataQty;
	}
	public void setDataQty(Integer dataQty) {
		this.dataQty = dataQty;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public SimDetailsDTO getSimDetails() {
		return simDetails;
	}
	public void setSimDetails(SimDetailsDTO simDetails) {
		this.simDetails = simDetails;
	}
	
}
