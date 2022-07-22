package com.workitem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workitem.DTO.VehicleWorkitemDTO;
import com.workitem.DTO.WorkitemDTO;
import com.workitem.service.WorkitemService;

@RestController
@RequestMapping("/ftr")
public class WorkitemController {
   
	@Autowired
	WorkitemService service;
	
	@PostMapping(value="/workitems")
	public ResponseEntity<WorkitemDTO> createWorkitem(@RequestBody WorkitemDTO newWorkitem){
		WorkitemDTO workitemDTO=service.createWorkitem(newWorkitem);
		ResponseEntity<WorkitemDTO> entity = new ResponseEntity<>(workitemDTO,HttpStatus.ACCEPTED);
		return entity;
	}
	@PutMapping(value="/workitems/{workitemId}")
	public ResponseEntity<String> updateWorkitem(@PathVariable String workitemId,@RequestBody WorkitemDTO workitemDTO){
		String message=service.updateWorkitemId(workitemId, workitemDTO);
		ResponseEntity<String> entity = new ResponseEntity<>(message,HttpStatus.ACCEPTED);
		return entity;
	}
	
	@GetMapping(value="/workitems/{fromCountry}")
	ResponseEntity<List<String>> fetchAvailableHarborLocations(@PathVariable String fromCountry) throws Exception{
		List<String> str = service.fetchAvailableHarborLocations(fromCountry);
		ResponseEntity<List<String>> entity = new ResponseEntity<>(str,HttpStatus.ACCEPTED);
		return entity;
	}
	@GetMapping(value="/workitems")
	ResponseEntity<List<WorkitemDTO>> fetchWorkitemDetails(){
		List<WorkitemDTO> workitems=service.fetchWorkitemDetails();
		ResponseEntity<List<WorkitemDTO>> entity = new ResponseEntity<>(workitems,HttpStatus.ACCEPTED);
		return entity;
	}
	
	@GetMapping(value="/workitems/managed-status/{workitemId}")
	ResponseEntity<VehicleWorkitemDTO> fetchWorkitemStatus(@PathVariable String workitemId) throws Exception {
		VehicleWorkitemDTO dto = service.fetchWorkitemStatus(workitemId);
		ResponseEntity<VehicleWorkitemDTO> entity = new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
		return entity;
	}
	
	@GetMapping(value="/workitems/managed-user/{userId}")
	ResponseEntity<List<WorkitemDTO>> trackWorkitemByUser(@PathVariable Long userId){
		List<WorkitemDTO> workitems=service.trackWorkitemByUser(userId);
		ResponseEntity<List<WorkitemDTO>> entity = new ResponseEntity<>(workitems,HttpStatus.ACCEPTED);
		return entity;
	}
	
	@GetMapping(value="/workitems/managed-vehicle/{vehicleNumber}")
	ResponseEntity<VehicleWorkitemDTO> fetchWorkitemDetailsByVehicleNumber(@PathVariable String vehicleNumber){
		VehicleWorkitemDTO dto = service.fetchWorkItemDetailsByVehicleNumber(vehicleNumber);
		ResponseEntity<VehicleWorkitemDTO> entity = new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
		return entity;
	}
	
}
