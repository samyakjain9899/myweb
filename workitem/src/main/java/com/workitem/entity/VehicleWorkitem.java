package com.workitem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ftr_vehicle_workitem")
public class VehicleWorkitem {
    @Id
	private String workitemId;
	private String vehicleNumber;
	private String driverId;
	private String assignedWorkitemStatus;
	
	
	public VehicleWorkitem() {
		super();
	}
	
	public VehicleWorkitem(String workitemId, String vehicleNumber, String driverId, String assignedWorkitemStatus) {
		super();
		this.workitemId = workitemId;
		this.vehicleNumber = vehicleNumber;
		this.driverId = driverId;
		this.assignedWorkitemStatus = assignedWorkitemStatus;
	}

	public String getWorkitemId() {
		return workitemId;
	}
	public void setWorkitemId(String workitemId) {
		this.workitemId = workitemId;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getAssignedWorkitemStatus() {
		return assignedWorkitemStatus;
	}
	public void setAssignedWorkitemStatus(String assignedWorkitemStatus) {
		this.assignedWorkitemStatus = assignedWorkitemStatus;
	}
	
}
