package com.oyerickshaw.rating.reposImpl;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oyerickshaw.rating.entity.DriverEntity;


@Repository
public interface DriverRepositoryImpl extends JpaRepository<DriverEntity, Long>{

	
	Boolean existsDriverByAadhaarNo(String aadharNo);
	Boolean existsDriverByDriverId(String driverId);
	Boolean existsDriverByPhNo(String phNo);
	DriverEntity findByDriverId(String driverId);
	
	DriverEntity findDriverAvgRatingByDriverId(String driverId);
	
	@Transactional
	@Modifying
	@Query("Update DriverEntity d set d.totalRide=?1, d.avgRating=?2 where d.driverId=?3")
	void updateDriverTotalRideAndAvgRating(int totalRides, double avgRating, String driverId);
}
