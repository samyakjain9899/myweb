package com.infy.customer.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.customer.dto.CustomerAddressDTO;
import com.infy.customer.entity.CustomerAddress;
import com.infy.customer.exception.InvalidCustomerAddressIdException;
import com.infy.customer.repository.CustomerAddressRepository;


@Service
@Transactional
public class CustomerAddressService {
	
	@Autowired
	CustomerAddressRepository customerAddressRepository;
	@Autowired
	Environment environment;
	
	public List<CustomerAddressDTO> getAllCustomerAddress() {
		List<CustomerAddress> customerAddress = customerAddressRepository.findAll();
		List<CustomerAddressDTO> customerAddressDTO = customerAddress.stream().map(i->i.convertEntityToDto()).toList();
		return customerAddressDTO;
	}
	
	public CustomerAddressDTO getCustomerAddressById(Integer addressId) throws InvalidCustomerAddressIdException {
		Optional<CustomerAddress> customerAddress = customerAddressRepository.findById(addressId);
		if(customerAddress.isPresent()) {
			CustomerAddressDTO customerAddressDTO = customerAddress.get().convertEntityToDto();
			return customerAddressDTO;
		}
		throw new InvalidCustomerAddressIdException(environment.getProperty("invalid_customer_address_id"));
	}
	
	public void addCustomerAddress(CustomerAddressDTO customerAddressDTO) {
		CustomerAddress customerAddress = customerAddressDTO.convertDtoToEntity();
		customerAddressRepository.save(customerAddress);
	}
	
	public CustomerAddressDTO updateCustomerAddress(Integer addressId, String address, String city, Integer pincode, String state) {
		Optional<CustomerAddress> customerAddressOptional = customerAddressRepository.findById(addressId);
		if(customerAddressOptional.isPresent()) {
			CustomerAddress customerAddress = customerAddressOptional.get();
			if(!customerAddress.getAddress().equals(address)) {
				customerAddress.setAddress(address);
			}
			if(!customerAddress.getCity().equals(city)) {
				customerAddress.setCity(city);
			}
			if(!customerAddress.getPincode().equals(pincode)) {
				customerAddress.setPincode(pincode);
			}
			if(!customerAddress.getState().equals(state)) {
				customerAddress.setState(state);
			}
			CustomerAddressDTO caDTO = customerAddress.convertEntityToDto();
			return caDTO;
		}
		CustomerAddress newCustomerAddress = new CustomerAddress();
		newCustomerAddress.setAddress(address);
		newCustomerAddress.setCity(city);
		newCustomerAddress.setPincode(pincode);
		newCustomerAddress.setState(state);
		customerAddressRepository.save(newCustomerAddress);
		return newCustomerAddress.convertEntityToDto();
	}

}
