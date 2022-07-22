package com.sim.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.sim.dto.CustomerDto;
import com.sim.dto.SimDetailsDto;
import com.sim.exception.AlreadyActive;
import com.sim.exception.InvalidValuesException;
import com.sim.service.CustomerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerSimFine simFeign;

	@Autowired
	CustomerService customerService;
	
	
	@Autowired
	RestTemplate restTemplate;
	
	String simUri=null;
	// add customer data
	
	@PostMapping("/add")
	public ResponseEntity<String> addCustomerData(@RequestBody CustomerDto customer) throws InvalidValuesException
	{
		System.out.println(customer.getuniqueId());
		ResponseEntity<String> entity= new ResponseEntity<>(customerService.addCustomerDetails(customer), HttpStatus.CREATED);
		return entity;
	}
	
	
	
	// 2. verify Customer Basics Details
	
	@PostMapping("/verifyCustomer")
	public ResponseEntity<String> verfiyCustomer(@RequestBody CustomerDto customer)  throws InvalidValuesException
	{
	
		
		ResponseEntity<String> entity= new ResponseEntity<>(customerService.verifyCustomerDeatils(customer), HttpStatus.FOUND);
		return entity;
	}

	
	// 3. Customer Personal Details:
	
	
	
	@PostMapping("/verifypersonal")
	public ResponseEntity<String> verfiyCustomerDreatils(@RequestBody CustomerDto customer)  throws InvalidValuesException
	{
	
		
		ResponseEntity<String> entity= new ResponseEntity<>(customerService.verifyCustomerPersonalDeatils(customer), HttpStatus.FOUND);
		return entity;
	}

	
	
	//4.Update Customer Address
	
	@PutMapping("/updateaddress")
	public ResponseEntity<String> updateCustomerAddress(@RequestBody CustomerDto customer)  throws InvalidValuesException
	{
	
		
		ResponseEntity<String> entity= new ResponseEntity<>(customerService.updateAddress(customer), HttpStatus.FOUND);
		return entity;
	}
	
	
	//5.Customer ID Proof Validation
	
	//Here we implemented  resillience4j and fallback , feign client , gateway, centralConfiguration on consul, services discovery, Load balancing and monitored using prometheus.
	
	@CircuitBreaker(name="customerService",fallbackMethod = "getVerifyProofFallback")
	@PostMapping("/validproof")
	public ResponseEntity<String> verfiyCustomerIdproofValidaton(@RequestBody CustomerDto customer)  throws InvalidValuesException ,AlreadyActive
	{
		
		CustomerDto custDTO=customerService.getCustomerProfile(customer.getuniqueId());
		SimDetailsDto ob=simFeign.getSpecificFriends(custDTO.getDetails().getSimId());
		custDTO.setDetails(ob);
		
		if(customerService.verifyCustomerIdentity(custDTO).equals("update"))
		{
			
			ResponseEntity<String> ob1= new ResponseEntity<String>(simFeign.updateSimStatus(custDTO.getDetails().getSimId()),HttpStatus.OK);
 	         return ob1;
		}
		
		ResponseEntity<String> entity= new ResponseEntity<>(customerService.verifyCustomerIdentity(custDTO), HttpStatus.FOUND);

		return entity;
	}
	
	
	public ResponseEntity<String> getVerifyProofFallback(CustomerDto customer, Throwable throwable)
	{
		System.out.println("===========Fallback================");
		return new ResponseEntity<String>("Fallback",HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
}
