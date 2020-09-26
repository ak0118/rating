package com.oyerickshaw.rating.service;

import com.oyerickshaw.rating.beans.Rating;
import com.oyerickshaw.rating.beans.Response;

public interface PassengerService {
	public Response getPassengerAverageRating(String passengerId);
	public Response updatePassengerAverageRating(Rating rating);
}
