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
import com.oyerickshaw.rating.serviceImpl.DriverServiceImpl;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired DriverServiceImpl driverService;
	
	@GetMapping(value= {"","/"})
	public Response getDriverAverageRating(@RequestHeader String driverId) {
		return driverService.getDriverAverageRating(driverId);
	}
	
	@PutMapping(value= {"","/"})
	public Response updateDriverAverageRating(@RequestBody Rating rating) {
		return driverService.updateDriverAverageRating(rating);
	}
}
