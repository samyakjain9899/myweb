package com.sim.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.dto.CustomerAddressDto;
import com.sim.entity.CustomerAddress;
import com.sim.repository.CustomerAddressRepository;

@Service
@Transactional
public class AddressService {

	@Autowired
	CustomerAddressRepository addressRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	// add address
	
	public String addAddress(CustomerAddressDto customerAddress) {
		addressRepository.save(modelMapper.map(customerAddress, CustomerAddress.class));
		
		return "Inserted customer address successfully";
		
	}

	//update address
	
	public String updateAddress(CustomerAddressDto customerAddress) {
		// TODO Auto-generated method stub
		
		if(addressRepository.findByAddress(customerAddress.getAddress()).isEmpty())
		{
			addressRepository.save(modelMapper.map(customerAddress, CustomerAddress.class));
             return "New Address is added";
		}
		else
		{
			return "Already Existed Update";
		}
	
	}

	
}
