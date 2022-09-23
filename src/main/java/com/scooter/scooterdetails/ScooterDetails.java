package com.scooter.scooterdetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class ScooterDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer scooterId;
	private String scooterName;
	private String scooterModel;
	private String scooterType;
	private String scooterPrice;

	public Integer getScooterId() {
		return scooterId;
	}

	public void setScooterId(Integer scooterId) {
		this.scooterId = scooterId;
	}

	public String getScooterName() {
		return scooterName;
	}

	public void setScooterName(String scooterName) {
		this.scooterName = scooterName;
	}

	public String getScooterModel() {
		return scooterModel;
	}

	public void setScooterModel(String scooterModel) {
		this.scooterModel = scooterModel;
	}

	public String getScooterType() {
		return scooterType;
	}

	public void setScooterType(String scooterType) {
		this.scooterType = scooterType;
	}

	public String getScooterPrice() {
		return scooterPrice;
	}

	public void setScooterPrice(String scooterPrice) {
		this.scooterPrice = scooterPrice;
	}

}
