package com.sim.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sim.dto.CustomerIdentityDto;
import com.sim.service.CustomerIdentityService;

@RestController
@RequestMapping("/customerIdentity")
public class CustomerIdentityController {

	@Autowired
	CustomerIdentityService customerIdentityService;
	
	
	// add customerIdentityData
	
	@PostMapping
	public ResponseEntity<String> addCustomerIdentity(@Valid @RequestBody CustomerIdentityDto customerIdentitydto) throws MethodArgumentNotValidException
	{
		System.out.println(customerIdentitydto.toString());
		ResponseEntity<String> entity = new ResponseEntity<>(customerIdentityService.addCustomerIdentityService(customerIdentitydto), HttpStatus.CREATED);
		return entity;
	}

	
}
