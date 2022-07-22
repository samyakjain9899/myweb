package com.sim.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.dto.CustomerIdentityDto;
import com.sim.entity.CustomerIdentity;
import com.sim.repository.CustomerIdentityRepository;

@Service
public class CustomerIdentityService {

	@Autowired
	CustomerIdentityRepository customerIdentityRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// add customerIdentity details yaswanth sai
	
	public String addCustomerIdentityService(CustomerIdentityDto customerIdentitydto) {
		
		customerIdentityRepository.save(modelMapper.map(customerIdentitydto, CustomerIdentity.class));
		return "Customer Identity inserted";
	}
	
	

}
