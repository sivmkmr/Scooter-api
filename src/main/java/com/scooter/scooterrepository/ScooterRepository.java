package com.scooter.scooterrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scooter.scooterdetails.ScooterDetails;

public interface ScooterRepository extends JpaRepository<ScooterDetails, Integer>{

}
