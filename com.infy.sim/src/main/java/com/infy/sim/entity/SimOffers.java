package com.infy.sim.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.infy.sim.dto.SimOffersDTO;

@Entity
public class SimOffers {

	@Id
	private Integer offerId;
	private Integer callQty;
	private Integer cost;
	private Integer dataQty;
	private Integer duration;
	private String offerName;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "simId", referencedColumnName = "simId")
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
	
	@Override
	public String toString() {
		return "SimOffers [offerId=" + offerId + ", callQty=" + callQty + ", cost=" + cost + ", dataQty=" + dataQty
				+ ", duration=" + duration + ", offerName=" + offerName + ", simDetails=" + simDetails + "]";
	}
	
	public SimOffersDTO convertEntityToDto() {
		SimOffersDTO simOffersDTO = new SimOffersDTO();
		simOffersDTO.setCallQty(this.callQty);
		simOffersDTO.setCost(this.cost);
		simOffersDTO.setDataQty(this.dataQty);
		simOffersDTO.setDuration(this.duration);
		simOffersDTO.setOfferId(this.offerId);
		simOffersDTO.setOfferName(this.offerName);
		simOffersDTO.setSimDetails(this.simDetails);
		return simOffersDTO;
	}
	
	
	
	
}
