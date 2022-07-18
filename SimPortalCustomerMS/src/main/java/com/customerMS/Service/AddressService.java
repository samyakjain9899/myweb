package com.customerMS.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerMS.DTO.AddressDTO;
import com.customerMS.Entity.CustomerAddress;
import com.customerMS.Repository.AddressRepository;

@Service("addressService")
@Transactional
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepo;
	
	public String addAddress(AddressDTO dto) throws Exception {
		
		
		Optional<CustomerAddress> optAddress = addressRepo.findBypincode(dto.getPincode());
		
		
		/**
		 * CHECK IF EXISTS THROUGH PINCODE
		 */
		if(optAddress.isPresent()) {
			throw new Exception("Address Exists already");
		}
		
		addressRepo.save(AddressDTO.convertDTOToEntity(dto));
		
		return "new Address recorded successfully";
		
		
	}

}
