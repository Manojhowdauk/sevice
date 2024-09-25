package com.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import lombok.Data;

@Data
@Document("order")
public class Order {

	@Id
	private String orderID;
	private String serviceTypeID;
	private String serviceTypeName;
	private String companyID;
	private String companyName;
	private String customerPhoneNo;
	private String customerID;
	private String customerName;
	private String vehicleNo;
	private String vehicleID;
	private String vehicleTypeID;
	private String vehicleTypeName;	
	private String date;	
	private long amount;
	private String orderStatus;
	private boolean PaymentStatus;
	private String PaymentType;
	private long creationTimeDate;
	private long orderCompletedTimeDate;
	private boolean deleteStatus;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
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
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public boolean isPaymentStatus() {
		return PaymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		PaymentStatus = paymentStatus;
	}
	public String getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}
	public long getCreationTimeDate() {
		return creationTimeDate;
	}
	public void setCreationTimeDate(long creationTimeDate) {
		this.creationTimeDate = creationTimeDate;
	}
	public long getOrderCompletedTimeDate() {
		return orderCompletedTimeDate;
	}
	public void setOrderCompletedTimeDate(long orderCompletedTimeDate) {
		this.orderCompletedTimeDate = orderCompletedTimeDate;
	}
	public boolean isDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	public String getVehicleTypeName() {
		return vehicleTypeName;
	}
	public void setVehicleTypeName(String vehicleTypeName) {
		this.vehicleTypeName = vehicleTypeName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
