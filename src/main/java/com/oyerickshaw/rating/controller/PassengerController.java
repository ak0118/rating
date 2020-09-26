package com.oyerickshaw.rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyerickshaw.rating.beans.Rating;
import com.oyerickshaw.rating.beans.Response;
import com.oyerickshaw.rating.serviceImpl.PassengerServiceImpl;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	
	@Autowired PassengerServiceImpl passengerService;
	
	@GetMapping(value= {"","/"})
	public Response getPassengerAverageRating(@RequestHeader String passengerId) {
		return passengerService.getPassengerAverageRating(passengerId);
	}
	
	@PutMapping(value= {"","/"})
	public Response updatePassengerAverageRating(@RequestBody Rating rating) {
		return passengerService.updatePassengerAverageRating(rating);
	}
	

}
