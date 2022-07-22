package com.sim.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sim.dto.CustomerAddressDto;
import com.sim.exception.InvalidValuesException;
import com.sim.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	
	// To new New Address to the table
	
	@PostMapping
	public ResponseEntity<String> add(@Valid @RequestBody CustomerAddressDto customerAddress)  throws InvalidValuesException
	{
	
		
		ResponseEntity<String> entity= new ResponseEntity<>(addressService.addAddress(customerAddress), HttpStatus.CREATED);
		return entity;
	}

  // to update address
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody CustomerAddressDto customerAddress)  throws InvalidValuesException
	{
	
		
		ResponseEntity<String> entity= new ResponseEntity<>(addressService.updateAddress(customerAddress), HttpStatus.CREATED);
		return entity;
	}
	
}
