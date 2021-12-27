package com.xoriant.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.xoriant.ecart.entity.AirlineInfo;
import com.xoriant.ecart.entity.AirlineInfoDao;
import com.xoriant.ecart.entity.FlightInfo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		AirlineInfoDao airlineDao = ac.getBean(AirlineInfoDao.class);
		
		AirlineInfo airlineInfo = airlineDao.findById(1).get();
		System.out.println(airlineInfo.getAirlineInfoId());
		System.out.println(airlineInfo.getAirlineName());
		System.out.println(airlineInfo.getAirlineLogo());
		System.out.println("------------------------------------");
		
		for(FlightInfo fi: airlineInfo.getFlightData()) {
			System.out.println(fi);
		}
		
	}

}
