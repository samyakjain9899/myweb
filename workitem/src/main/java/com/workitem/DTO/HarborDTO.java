package com.workitem.DTO;

import com.workitem.entity.Harbor;

public class HarborDTO {

	private String country;
	private String availableHarborLocations;
	
	public HarborDTO() {
		super();
	}
	public HarborDTO(String country, String availableHarborLocations) {
		super();
		this.country = country;
		this.availableHarborLocations = availableHarborLocations;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAvailableHarborLocations() {
		return availableHarborLocations;
	}
	public void setAvailableHarborLocations(String availableHarborLocations) {
		this.availableHarborLocations = availableHarborLocations;
	}
	
	public static Harbor createEntity(HarborDTO dto) {
		Harbor entity = new Harbor();
		entity.setAvailableHarborLocations(dto.getAvailableHarborLocations());
		entity.setCountry(dto.getCountry());
		return entity;
	}
	public static HarborDTO valueOf(Harbor entity) {
		HarborDTO dto = new HarborDTO();
		dto.setAvailableHarborLocations(entity.getAvailableHarborLocations());
		dto.setCountry(entity.getCountry());
		return dto;
	}
}
