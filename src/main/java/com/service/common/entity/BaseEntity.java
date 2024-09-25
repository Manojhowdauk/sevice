package com.service.common.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseEntity {

	// @Column(value="createddate")
	@JsonProperty(value = "createddate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@CreatedDate
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private LocalDateTime createdDate;

//	@Column("modifieddate")
	@JsonProperty("modifieddate")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@LastModifiedDate
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private LocalDateTime modifiedDate;

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

//	public void setCreatedDate(LocalDateTime createdDate) {
//		this.createdDate = createdDate  == null ?  LocalDateTime.now() : createdDate ;
//	}
//
//	public void setModifiedDate() {
//		this.modifiedDate = LocalDateTime.now();
//	}

//	public LocalDateTime getCreatedDate() {
//		return createdDate;
//	}
//
//	public LocalDateTime getModifiedDate() {
//		return modifiedDate;
//	}

}
