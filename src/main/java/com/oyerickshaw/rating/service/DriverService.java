package com.oyerickshaw.rating.service;

import com.oyerickshaw.rating.beans.Rating;
import com.oyerickshaw.rating.beans.Response;

public interface DriverService {
	public Response getDriverAverageRating(String driverId);
	public Response updateDriverAverageRating(Rating rating);
}
