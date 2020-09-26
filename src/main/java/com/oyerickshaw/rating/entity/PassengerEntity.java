package com.oyerickshaw.rating.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oyerickshaw.rating.beans.AbstractEntity;

@Entity
@Table(name = "passenger_info")
@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassengerEntity extends AbstractEntity<Long> implements Serializable{

	@Column(name = "name")
	private String name = "";
	
	@Column(name = "passenger_id")
	private String passengerId = "";
	
	@Column(name = "ph_no")
	private String phNo = "";
	
	@Column(name = "total_rides")
	private int totalRides = 0;
	
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
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Boolean getIsValidated() {
		return isValidated;
	}
	public void setIsValidated(Boolean isValidated) {
		this.isValidated = isValidated;
	}
	public int getTotalRides() {
		return totalRides;
	}
	public void setTotalRides(int totalRides) {
		this.totalRides = totalRides;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
}
