package com.FTR.DTO;

import java.time.LocalDate;

public class WorkitemVehicleDTO {
	private String vehicleNumber;
	private String vehicleName;
	private Double maxLiftingCapacity;
	private LocalDate retireDate;
	private String vehicleStatus;
	private String harborLocation;
	private String country;
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public WorkitemVehicleDTO(String vehicleNumber, String vehicleName, Double maxLiftingCapacity, LocalDate retireDate,
			String vehicleStatus, String harborLocation, String country) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.maxLiftingCapacity = maxLiftingCapacity;
		this.retireDate = retireDate;
		this.vehicleStatus = vehicleStatus;
		this.harborLocation = harborLocation;
		this.country = country;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Double getMaxLiftingCapacity() {
		return maxLiftingCapacity;
	}
	public void setMaxLiftingCapacity(Double maxLiftingCapacity) {
		this.maxLiftingCapacity = maxLiftingCapacity;
	}
	public LocalDate getRetireDate() {
		return retireDate;
	}
	public void setRetireDate(LocalDate retireDate) {
		this.retireDate = retireDate;
	}
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public String getHarborLocation() {
		return harborLocation;
	}
	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
