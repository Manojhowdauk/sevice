package com.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document("vehicletype")
public class VehicleTypeMaster {

	@Id
	@NotNull
	private String vehicleTypeID;
	private String vehicleTypeName;
	private String companyID;
	private String companyName;
	private long creationTimeDate;
	private boolean deleteStatus;
	public String getVehicleTypeID() {
		return vehicleTypeID;
	}
	public void setVehicleTypeID(String vehicleTypeID) {
		this.vehicleTypeID = vehicleTypeID;
	}
	public String getVehicleTypeName() {
		return vehicleTypeName;
	}
	public void setVehicleTypeName(String vehicleTypeName) {
		this.vehicleTypeName = vehicleTypeName;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
