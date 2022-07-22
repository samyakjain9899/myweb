package com.workitem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ftr_harbor")
public class Harbor {
    @Id
	private String country;
	private String availableHarborLocations;
	
	public Harbor() {
		super();
	}
	public Harbor(String country, String availableHarborLocations) {
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
	
	
}
