package com.sim.dto;


public class SimOffersDto {
	
	private Integer offerId;
	private Integer callQty;
	private Integer cost;
	private Integer dataQty;
	private Integer duration;
	private String offerName;
	
	public Integer getOfferId() {
		return offerId;
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
	
	
	
	

	@Override
	public String toString() {
		return "SimOffers [offerId=" + offerId + ", callQty=" + callQty + ", cost=" + cost + ", dataQty=" + dataQty
				+ ", duration=" + duration + ", offerName=" + offerName + "]";
	}
	public SimOffersDto(Integer offerId, Integer callQty, Integer cost, Integer dataQty, Integer duration,
			String offerName) {
		super();
		this.offerId = offerId;
		this.callQty = callQty;
		this.cost = cost;
		this.dataQty = dataQty;
		this.duration = duration;
		this.offerName = offerName;
	}
	public SimOffersDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
