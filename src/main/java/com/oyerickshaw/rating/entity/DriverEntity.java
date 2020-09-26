package com.oyerickshaw.rating.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oyerickshaw.rating.beans.AbstractEntity;

@Entity
@Table(name = "driver_info")
@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverEntity extends AbstractEntity<Long> implements Serializable{

	@Column(name = "name")
	private String name = "";
	
	@Column(name = "licence_no")
	private String licenceNo = "";
	
	@Column(name = "aadhaar_no")
	private String aadhaarNo = "";
	
	@Column(name = "driver_id")
	private String driverId = "";
	
	@Column(name = "ph_no")
	private String phNo = "";
	
	@Column(name = "total_rides")
	private int totalRide = 0;
	
	@Column(name = "avg_rating")
	private double avgRating = 0.0;
	
	@Column(name = "otp")
	private String otp = "";
	
	@Column(name = "is_validated", columnDefinition="boolean default false")
	private Boolean isValidated;
	
	@PrePersist
	public void defaultIsValidated() {
		if (isValidated == null) {
			isValidated = false;
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	public String getAadhaarNo() {
		return aadhaarNo;
	}
	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public int getTotalRide() {
		return totalRide;
	}
	public void setTotalRide(int totalRide) {
		this.totalRide = totalRide;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	public Boolean isValidated() {
		return isValidated;
	}
	public void setValidated(Boolean isValidated) {
		this.isValidated = isValidated;
	}
	
}
