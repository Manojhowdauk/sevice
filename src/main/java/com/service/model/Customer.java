package com.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("customer")
public class Customer {
	
	@Id
	private String customerPhoneNo;
	private String customerID;
	private String customerName;
	private long creationTimeDate;
	private boolean deleteStatus;
	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}
	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
