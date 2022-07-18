package com.infy.sim.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.sim.dto.SimDetailsDTO;
import com.infy.sim.exception.SimAlreadyActiveException;
import com.infy.sim.exception.SimServiceNumberInvalidException;
import com.infy.sim.service.SimDetailsService;

@RestController
@RequestMapping("/sim/details")
@Validated
@CrossOrigin
public class SimDetailsController {
	
	@Autowired
	SimDetailsService simDetailsService;
	@Autowired
	private Environment environment;
	
	@GetMapping
	public ResponseEntity<List<SimDetailsDTO>> getAllSimDetails() {
		return ResponseEntity.ok().body(simDetailsService.getAllSimDetails());
	}
	
	@GetMapping("/{simId}")
	public ResponseEntity<SimDetailsDTO> getSimDetailsById(@PathVariable Integer simId) {
		return ResponseEntity.ok().body(simDetailsService.getSimDetailsById(simId));
	}
	
	@GetMapping("/{simNumber}/{serviceNumber}")
	public ResponseEntity<SimDetailsDTO> validateSimDetails(@PathVariable 
					@Size(min=13,max=13, message="SIM number should be 13-digit numeric value") 
					String simNumber, @PathVariable 
					@Size(min=10,max=10, message="Service number should be 10-digit numeric value") 
					String serviceNumber) throws SimAlreadyActiveException, SimServiceNumberInvalidException {
		SimDetailsDTO simDetailsDTO = simDetailsService.validateSimDetails(simNumber, serviceNumber);
		ResponseEntity<SimDetailsDTO> responseEntity = new ResponseEntity<>(simDetailsDTO,HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping
	public ResponseEntity<String> addSimDetails(@Valid @RequestBody SimDetailsDTO simDetailsDTO) {
		simDetailsService.addSimDetails(simDetailsDTO);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(environment.getProperty("sim_details_added_success"),HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/{simId}/uid/{uniqueIdNumber}")
	public ResponseEntity<SimDetailsDTO> updateSimDetails(@PathVariable String simId, @PathVariable String uniqueIdNumber) {
		SimDetailsDTO simDetailsDTO = simDetailsService.updateUniqueIdNumber(Integer.valueOf(simId), uniqueIdNumber);
		ResponseEntity<SimDetailsDTO> responseEntity = new ResponseEntity<>(simDetailsDTO,HttpStatus.ACCEPTED);
		return responseEntity;
	}
	@PutMapping("/{simId}/status/{simStatus}")
	public ResponseEntity<SimDetailsDTO> updateSimDetailsStatus(@PathVariable String simId, @PathVariable String simStatus) {
		SimDetailsDTO simDetailsDTO = simDetailsService.updateSimStatus(Integer.valueOf(simId), simStatus);
		ResponseEntity<SimDetailsDTO> responseEntity = new ResponseEntity<>(simDetailsDTO,HttpStatus.ACCEPTED);
		return responseEntity;
	}
}
