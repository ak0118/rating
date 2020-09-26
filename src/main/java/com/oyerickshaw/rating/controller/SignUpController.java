package com.oyerickshaw.rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyerickshaw.rating.beans.Response;
import com.oyerickshaw.rating.entity.DriverEntity;
import com.oyerickshaw.rating.entity.PassengerEntity;
import com.oyerickshaw.rating.serviceImpl.SignUpServiceImpl;

@RestController
@RequestMapping("/signup")
public class SignUpController {

	@Autowired SignUpServiceImpl signUpService;
	
	@PostMapping("/driver")
	public Response registerDriver(@RequestBody DriverEntity driver) {
		return signUpService.registerDriver(driver);
	}
	
	@PostMapping("/passenger")
	public Response registerPasseger(@RequestBody PassengerEntity passenger) {
		return signUpService.registerPassenger(passenger);
	}
}
