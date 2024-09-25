package com.service.model;

import org.springframework.data.annotation.Id;

public class Vehicle {
	
	
	@Id
	private String vehicleNo;
	private String vehicleID;
	private String vehicleTypeID;
	private long creationTimeDate;
	private boolean deleteStatus;
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getVehicleTypeID() {
		return vehicleTypeID;
	}
	public void setVehicleTypeID(String vehicleTypeID) {
		this.vehicleTypeID = vehicleTypeID;
	}
	public long getCreationTimeDate() {
		return creationTimeDate;
	}
	public void setCreationTimeDate(long creationTimeDate) {
		this.creationTimeDate = creationTimeDate;
	}
	public boolean isDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
	

}
