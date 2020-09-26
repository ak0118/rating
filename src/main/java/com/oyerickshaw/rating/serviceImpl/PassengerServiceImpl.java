package com.oyerickshaw.rating.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyerickshaw.rating.beans.Rating;
import com.oyerickshaw.rating.beans.Response;
import com.oyerickshaw.rating.entity.DriverEntity;
import com.oyerickshaw.rating.entity.PassengerEntity;
import com.oyerickshaw.rating.reposImpl.PassengerRepositoryImpl;
import com.oyerickshaw.rating.service.PassengerService;
import com.oyerickshaw.rating.util.Utility;

@Service
public class PassengerServiceImpl implements PassengerService{

	@Autowired PassengerRepositoryImpl passRepo;
	
//	This method returns average rating and total rides taken by passenger
	@Override
	public Response getPassengerAverageRating(String passengerId) {
		try {
			Response res = Utility.success.apply(passengerId, "Successfully fetched passenger details");
			Rating rating = new Rating();
			PassengerEntity passEntity = passRepo.findPassengerAvgRatingByPassengerId(passengerId);
			rating.setAvgRating(passEntity.getAvgRating());
			rating.setId(passengerId);
			rating.setTotalRides(passEntity.getTotalRides());
			res.setPayload(Utility.getPayload.apply(rating));
			return res;
		}catch(Exception e) {
			e.printStackTrace();
			return Utility.failure.apply(passengerId, e.getMessage());
		}
	}
	
//	This method updates the average rating and the total rides of passenger
	@Override
	public Response updatePassengerAverageRating(Rating rating) {
		try {
			PassengerEntity passEntity = passRepo.findPassengerAvgRatingByPassengerId(rating.getId());
			passRepo.updatePassengerTotalRideAndAvgRating(passEntity.getTotalRides() + rating.getTotalRides(),
					(passEntity.getAvgRating() + rating.getAvgRating())
							/ (passEntity.getTotalRides() + rating.getTotalRides()),
					rating.getId());
			return Utility.success.apply(rating.getId(), "Successfully Updated passenger average rating");
		}catch(Exception e) {
			e.printStackTrace();
			return Utility.failure.apply(rating.getId(), e.getMessage());
		}
	}

}
