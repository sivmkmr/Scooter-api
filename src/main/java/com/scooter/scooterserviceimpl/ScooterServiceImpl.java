package com.scooter.scooterserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scooter.apiresponse.ApiResponse;
import com.scooter.globalconstant.GlobalConstant;
import com.scooter.scooterdetails.ScooterDetails;
import com.scooter.scootermodel.ScooterModel;
import com.scooter.scooterrepository.ScooterRepository;
import com.scooter.scooterservice.ScooterService;

@Service
public class ScooterServiceImpl implements ScooterService {

	@Autowired
	ScooterRepository scooterRepository;

	ScooterDetails scooterDetails = new ScooterDetails();
	
//	ScooterDetails scooterDetails = new ScooterDetails();

//	Dummy API Block
	@Override
	public ApiResponse dummyApi() {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(GlobalConstant.dummyApi);
		return apiResponse;
	}

//	Data Insertion Block
	@Override
	public ApiResponse saveData(ScooterModel scooterModel) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		ScooterDetails scooterDetails = new ScooterDetails();
		try {
			
				scooterDetails.setScooterName(scooterModel.getScooterName());
				scooterDetails.setScooterModel(scooterModel.getScooterModel());
				scooterDetails.setScooterType(scooterModel.getScooterType());
				scooterDetails.setScooterPrice(scooterModel.getScooterPrice());
				scooterRepository.save(scooterDetails);
				apiResponse.setMessage(GlobalConstant.dataInsertSuccess);
			
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse.setMessage(GlobalConstant.dataInsertFail);
		}
		return apiResponse;
	}

//	Get All Data Block

	@Override
	public ApiResponse getAllData() {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		List<ScooterDetails> dbData = scooterRepository.findAll();
		if (dbData.isEmpty()) {
			apiResponse.setMessage(GlobalConstant.getAllDataFail);
		} else {
			apiResponse.setAllScooterDetails(dbData);
			apiResponse.setMessage(GlobalConstant.getAllDataSuccess);
		}
		return apiResponse;
	}

//	Data Get By Id Block

	@Override
	public ApiResponse getDatabyId(Integer id) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		Optional<ScooterDetails> dbData = scooterRepository.findById(id);
		if (dbData.isEmpty()) {
			apiResponse.setMessage(GlobalConstant.getAllDataFail);
		} else {
//			scooterDetails = dbData.get();
			apiResponse.setScooterDetails(dbData.get());
			apiResponse.setMessage(GlobalConstant.getAllDataSuccess);
		}
		return apiResponse;
	}

//	Data Updation Block

	@Override
	public ApiResponse dataUpdation(ScooterModel scooterModel, Integer id) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();

		Optional<ScooterDetails> dbData = scooterRepository.findById(id);
		if (dbData.isEmpty()) {
			apiResponse.setMessage(GlobalConstant.dataUpdateFail);
		} else {
//			ScooterDetails scooterDetails = dbData.get();
			scooterDetails = dbData.get();
			scooterDetails.setScooterName(scooterModel.getScooterName());
			scooterDetails.setScooterModel(scooterModel.getScooterModel());
			scooterDetails.setScooterType(scooterModel.getScooterType());
			scooterDetails.setScooterPrice(scooterModel.getScooterPrice());
			scooterRepository.save(scooterDetails);
			apiResponse.setMessage(GlobalConstant.dataUpdateSuccess);
		}
		return apiResponse;
	}

//	Data Patch Updation Block

	@Override
	public ApiResponse dataUpdationByPatch(Integer id, ScooterModel scooterModel) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		Optional<ScooterDetails> dbData = scooterRepository.findById(id);
		if (dbData.isEmpty()) {
			apiResponse.setMessage(GlobalConstant.dataUpdateFail);
		} else {
			ScooterDetails scooterDetails = dbData.get();
			
			scooterDetails.setScooterName(scooterModel.getScooterName());
			scooterDetails.setScooterModel(scooterModel.getScooterModel());
			scooterDetails.setScooterType(scooterModel.getScooterType());
			scooterDetails.setScooterPrice(scooterModel.getScooterPrice());
			scooterRepository.save(scooterDetails);
			apiResponse.setMessage(GlobalConstant.dataUpdateSuccess);
		}
		return apiResponse;
	}

//	Data Deletion Block

	@Override
	public ApiResponse dataDeletionById(Integer id) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		Optional<ScooterDetails> dbData = scooterRepository.findById(id);
		if (dbData.isEmpty()) {
			apiResponse.setMessage(GlobalConstant.deletionFailed);
		} else {
			scooterRepository.deleteById(id);
			apiResponse.setMessage(GlobalConstant.deletionSuccess);
		}
		return apiResponse;
	}
}