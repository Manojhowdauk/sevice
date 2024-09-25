package com.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document("servicetype")
public class ServiceTypeMaster {
	
	@Id
	@NotNull
	private String serviceTypeID;
	private String serviceTypeName;
	private String companyID;
	private String companyName;
	private long creationTimeDate;
	private boolean deleteStatus;
	public String getServiceTypeID() {
		return serviceTypeID;
	}
	public void setServiceTypeID(String serviceTypeID) {
		this.serviceTypeID = serviceTypeID;
	}
	public String getServiceTypeName() {
		return serviceTypeName;
	}
	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
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
