package com.oyerickshaw.rating.beans;

public class Rating {

	private String id = "";
	private int totalRides = 0;
	private double avgRating = 0.0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
