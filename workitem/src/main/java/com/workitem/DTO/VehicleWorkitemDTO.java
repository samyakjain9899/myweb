package com.workitem.DTO;

import com.workitem.entity.VehicleWorkitem;

public class VehicleWorkitemDTO {

	private String workitemId;
	private String vehicleNumber;
	private String driverId;
	private String assignedWorkitemStatus;
	
	
	public VehicleWorkitemDTO() {
		super();
	}
	
	public VehicleWorkitemDTO(String workitemId, String vehicleNumber, String driverId, String assignedWorkitemStatus) {
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
	public static VehicleWorkitemDTO valueOf(VehicleWorkitem entity) {
		VehicleWorkitemDTO dto = new VehicleWorkitemDTO();
		dto.setAssignedWorkitemStatus(entity.getAssignedWorkitemStatus());
		dto.setDriverId(entity.getDriverId());
		dto.setVehicleNumber(entity.getVehicleNumber());
		dto.setWorkitemId(entity.getWorkitemId());
		return dto;
	}
	
	public static VehicleWorkitem createEntity(VehicleWorkitemDTO dto) {
		VehicleWorkitem entity = new VehicleWorkitem();
		entity.setAssignedWorkitemStatus(dto.getAssignedWorkitemStatus());
		entity.setDriverId(dto.getDriverId());
		entity.setVehicleNumber(dto.getVehicleNumber());
		entity.setWorkitemId(dto.getWorkitemId());
		return entity;
	}
	
}
