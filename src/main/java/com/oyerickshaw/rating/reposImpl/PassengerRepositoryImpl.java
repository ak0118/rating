package com.oyerickshaw.rating.reposImpl;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oyerickshaw.rating.entity.PassengerEntity;

@Repository
public interface PassengerRepositoryImpl extends JpaRepository<PassengerEntity, Long>{

	Boolean existsPassengerByPhNo(String phNo);
	Boolean existsPassengerByPassengerId(String passId);
	PassengerEntity findByPassengerId(String passId);
	
	PassengerEntity findPassengerAvgRatingByPassengerId(String passId);
	
	@Transactional
	@Modifying
	@Query("Update PassengerEntity p set p.totalRides=?1, p.avgRating=?2 where p.passengerId=?3")
	void updatePassengerTotalRideAndAvgRating(int totalRides, double avgRating, String passId);
}
