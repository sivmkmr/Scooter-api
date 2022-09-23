package com.scooter.scooterservice;

import com.scooter.apiresponse.ApiResponse;
import com.scooter.scootermodel.ScooterModel;

public interface ScooterService {

	ApiResponse dummyApi();

	ApiResponse saveData(ScooterModel scooterModel);

	ApiResponse getAllData();

	ApiResponse getDatabyId(Integer id);

	ApiResponse dataUpdation(ScooterModel scooterModel, Integer id);

	ApiResponse dataUpdationByPatch(Integer id,ScooterModel scooterModel);

	ApiResponse dataDeletionById(Integer id);

}
