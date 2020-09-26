package com.oyerickshaw.rating.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyerickshaw.rating.beans.Rating;
import com.oyerickshaw.rating.beans.Response;
import com.oyerickshaw.rating.entity.DriverEntity;
import com.oyerickshaw.rating.reposImpl.DriverRepositoryImpl;
import com.oyerickshaw.rating.service.DriverService;
import com.oyerickshaw.rating.util.Utility;

@Service
public class DriverServiceImpl implements DriverService{

	@Autowired DriverRepositoryImpl driverRepo;
	
//	This method returns average rating and total rides taken by driver
	@Override
	public Response getDriverAverageRating(String driverId) {
		try {
			Response res = Utility.success.apply(driverId, "Successfully fetched driver details");
			Rating rating = new Rating();
			DriverEntity drEntity = driverRepo.findDriverAvgRatingByDriverId(driverId);
			rating.setAvgRating(drEntity.getAvgRating());
			rating.setId(driverId);
			rating.setTotalRides(drEntity.getTotalRide());
			res.setPayload(Utility.getPayload.apply(rating));
			return res;
		}catch(Exception e) {
			e.printStackTrace();
			return Utility.failure.apply(driverId, e.getMessage());
		}
	}
	
	
//	This method updates the average rating and the total rides of driver
	@Override
	public Response updateDriverAverageRating(Rating rating) {
		try {
//			fetched driver data from sql
			DriverEntity drEntity = driverRepo.findDriverAvgRatingByDriverId(rating.getId()); 
			driverRepo.updateDriverTotalRideAndAvgRating(drEntity.getTotalRide() + rating.getTotalRides(),
					(drEntity.getAvgRating() + rating.getAvgRating())
							/ (drEntity.getTotalRide() + rating.getTotalRides()),
					rating.getId());
			return Utility.success.apply(rating.getId(), "Successfully Updated driver average rating");
		}catch(Exception e) {
			e.printStackTrace();
			return Utility.failure.apply(rating.getId(), e.getMessage());
		}
	}

}
