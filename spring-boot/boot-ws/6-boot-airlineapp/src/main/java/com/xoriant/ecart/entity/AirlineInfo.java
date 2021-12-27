package com.xoriant.ecart.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class AirlineInfo {

	@Id
	@GeneratedValue
	private int airlineInfoId;
	private String airlineName;
	private String airlineLogo;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="flights",joinColumns = {@JoinColumn(name="airlineInfoId")},
	inverseJoinColumns = {@JoinColumn(name="flightId")} )
	private List<FlightInfo> flightData=new ArrayList<>();
	
	

	public List<FlightInfo> getFlightData() {
		return flightData;
	}

	public void setFlightData(List<FlightInfo> flightData) {
		this.flightData = flightData;
	}

	public int getAirlineInfoId() {
		return airlineInfoId;
	}

	public void setAirlineInfoId(int airlineInfoId) {
		this.airlineInfoId = airlineInfoId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getAirlineLogo() {
		return airlineLogo;
	}

	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}

	@Override
	public String toString() {
		return "AirlineInfo [airlineInfoId=" + airlineInfoId + ", airlineName=" + airlineName + ", airlineLogo="
				+ airlineLogo + "]";
	}

}
