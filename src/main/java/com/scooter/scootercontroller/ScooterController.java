package com.scooter.scootercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scooter.apiresponse.ApiResponse;
import com.scooter.scootermodel.ScooterModel;
import com.scooter.scooterservice.ScooterService;

@RestController
public class ScooterController {

	@Autowired
	private ScooterService scooterService;

//	Dummy API for Testing

	@GetMapping("/dummy-api")
	public ResponseEntity<ApiResponse> dummyApi() {
		ApiResponse response = scooterService.dummyApi();
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

//	Data Insertion Block

	@PostMapping("/data-insertion")
	public ResponseEntity<ApiResponse> saveData(@RequestBody ScooterModel scooterModel) {
		ApiResponse response = scooterService.saveData(scooterModel);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

//	Get All Data
	@GetMapping("/get-all-data")
	public ResponseEntity<ApiResponse> getAllData() {
		ApiResponse response = scooterService.getAllData();
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

//	Get All Data
	@GetMapping("/get-data-by-id/{id}")
	public ResponseEntity<ApiResponse> getDataById(@PathVariable("id") Integer id) {
		ApiResponse response = scooterService.getDatabyId(id);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

//	Data Updation Block
	@PutMapping("/data-update-by-put/{id}")
	public ResponseEntity<ApiResponse> dataUpdation(@RequestBody ScooterModel scooterModel,
			@PathVariable("id") Integer id) {
		ApiResponse response = scooterService.dataUpdation(scooterModel, id);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

//	Data Patch Updation Block
	@PatchMapping("/data-update-by-patch/{id}")
	public ResponseEntity<ApiResponse> dataUpdationByPatch(@PathVariable("id") Integer id,
			@RequestBody ScooterModel scooterModel) {
		ApiResponse response = scooterService.dataUpdationByPatch(id, scooterModel);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

//	Data Deletion Block
	@DeleteMapping("/data-delete-by-id/{id}")
	public ResponseEntity<ApiResponse> dataDeletionById(@PathVariable("id") Integer id) {
		ApiResponse response = scooterService.dataDeletionById(id);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

}
