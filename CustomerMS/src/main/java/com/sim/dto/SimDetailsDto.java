package com.sim.dto;

import java.util.List;



public class SimDetailsDto {
	
	private Integer simId;
	private String serviceNumber;
	private String simNumber;
private List<SimOffersDto> simOffers;
	
	public List<SimOffersDto> getSimOffers() {
		return simOffers;
	}
	public void setSimOffers(List<SimOffersDto> simOffers) {
		this.simOffers = simOffers;
	}
	public void setSimId(Integer simId) {
		this.simId = simId;
	}
	private String simStatus;
	public Integer getSimId() {
		return simId;
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
	@Override
	public String toString() {
		return "SimDetails [simId=" + simId + ", serviceNumber=" + serviceNumber + ", simNumber=" + simNumber
				+ ", simStatus=" + simStatus + "]";
	}
	public SimDetailsDto(Integer simId, String serviceNumber, String simNumber, String simStatus) {
		super();
		this.simId = simId;
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus = simStatus;
	}
	public SimDetailsDto() {
		super();
		// TODO Auto-generated m yaswanth sai constructor stub
	}
}
