package com.oyerickshaw.rating.service;

import com.oyerickshaw.rating.beans.Response;
import com.oyerickshaw.rating.entity.DriverEntity;
import com.oyerickshaw.rating.entity.PassengerEntity;

public interface SignUpService {

	public Response registerDriver(DriverEntity driver);
	public Response registerPassenger(PassengerEntity passenger);
}
