package com.scooter.apiresponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.scooter.scooterdetails.ScooterDetails;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

	private String message;

	private ScooterDetails scooterDetails;

	private List<ScooterDetails> allScooterDetails;

//	Getters And Setters

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ScooterDetails getScooterDetails() {
		return scooterDetails;
	}

	public void setScooterDetails(ScooterDetails scooterDetails) {
		this.scooterDetails = scooterDetails;
	}

	public List<ScooterDetails> getAllScooterDetails() {
		return allScooterDetails;
	}

	public void setAllScooterDetails(List<ScooterDetails> allScooterDetails) {
		this.allScooterDetails = allScooterDetails;
	}

}
