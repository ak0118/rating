package com.oyerickshaw.rating.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyerickshaw.rating.beans.Response;
import com.oyerickshaw.rating.entity.DriverEntity;
import com.oyerickshaw.rating.entity.PassengerEntity;
import com.oyerickshaw.rating.reposImpl.DriverRepositoryImpl;
import com.oyerickshaw.rating.reposImpl.PassengerRepositoryImpl;
import com.oyerickshaw.rating.service.SignUpService;
import com.oyerickshaw.rating.util.Utility;

@Service
public class SignUpServiceImpl implements SignUpService{

	@Autowired DriverRepositoryImpl driverDao;
	@Autowired PassengerRepositoryImpl passengerDao;
	
//	This method registers the driver with unique phone no
	@Override
	public Response registerDriver(DriverEntity driver) {
		try {
			if(driverDao.existsDriverByPhNo(driver.getPhNo())) return Utility.newSuccess.apply(driver.getPhNo(), "Driver already exists");
			else {
				driver.setDriverId(Utility.getIds.apply("driver_"));
				driver.setOtp(Utility.generateOtp.get()); // OTP can be used for validating phone no. Msg can be sent via AWS SNS
				driverDao.save(driver);
				Response res = Utility.success.apply(driver.getDriverId(), "Successfully registered with us");
				res.setPayload(Utility.getPayload.apply(driver));
				return res;
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
			return Utility.failure.apply(driver.getPhNo(), e.getMessage());
		}
	}

//	This method registers the passenger with unique phone no
	@Override
	public Response registerPassenger(PassengerEntity passenger) {
		try {
			if(passengerDao.existsPassengerByPhNo(passenger.getPhNo())) return Utility.newSuccess.apply(passenger.getPhNo(), "Passenger already exists");
			else {
				passenger.setPassengerId(Utility.getIds.apply("passenger_"));
				passenger.setOtp(Utility.generateOtp.get()); // OTP can be used for validating phone no. Msg can be sent via AWS SNS
				passengerDao.save(passenger);
				Response res = Utility.success.apply(passenger.getPassengerId(), "Successfully registered with us");
				res.setPayload(Utility.getPayload.apply(passenger));
				return res;
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
			return Utility.failure.apply(passenger.getPhNo(), e.getMessage());
		}
	}

}
