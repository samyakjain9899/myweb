package com.infy.sim.dto;

import com.infy.sim.entity.SimDetails;
import com.infy.sim.entity.SimOffers;

public class SimOffersDTO {
	private Integer offerId;
	private Integer callQty;
	private Integer cost;
	private Integer dataQty;
	private Integer duration;
	private String offerName;
	private SimDetails simDetails;
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
	public SimDetails getSimDetails() {
		return simDetails;
	}
	public void setSimDetails(SimDetails simDetails) {
		this.simDetails = simDetails;
	}
	
	public SimOffers convertDtoToEntity() {
		SimOffers simOffers = new SimOffers();
		simOffers.setCallQty(this.callQty);
		simOffers.setCost(this.cost);
		simOffers.setDataQty(this.dataQty);
		simOffers.setDuration(this.duration);
		simOffers.setOfferId(this.offerId);
		simOffers.setOfferName(this.offerName);
		simOffers.setSimDetails(this.simDetails);
		return simOffers;
	}
	
	
	
}
