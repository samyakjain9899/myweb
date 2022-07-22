package com.sim.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sim.dto.CustomerDto;
import com.sim.entity.Customer;
import com.sim.entity.CustomerIdentity;
import com.sim.exception.AlreadyActive;
import com.sim.exception.InvalidValuesException;
import com.sim.repository.CustomerAddressRepository;
import com.sim.repository.CustomerIdentityRepository;
import com.sim.repository.CustomerRepository;


import java.util.*;
import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

	




	@Autowired
	CustomerRepository customerRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	CustomerIdentityRepository customerIdentityRepository;
	
 

	private CustomerAddressRepository addressRepository;
	
	
	public CustomerService(CustomerAddressRepository addressRepository) {
		super();
	
		this.addressRepository = addressRepository;
	}


      // add customer details


	public String addCustomerDetails(CustomerDto customerdto) throws InvalidValuesException
	{
		System.out.println(customerRepository.findByEmailAddress(customerdto.getEmailAddress()));
		if(!customerRepository.findByEmailAddress(customerdto.getEmailAddress()).isEmpty())
		{
			throw new InvalidValuesException("Already Exited");
		}
		else
		{
		customerRepository.save(modelMapper.map(customerdto, Customer.class));
		
		return "Inserted customer successfully";
	}
	}


	  // verify customer basic details


	public String verifyCustomerDeatils(CustomerDto customer)  throws InvalidValuesException {
		if(customerRepository.findByEmailAndDOB(customer.getEmailAddress(),customer.getDateOfBirth()).isEmpty())
		{
			 throw new InvalidValuesException("No request placed for you");

		}
		else
		{
			return "valid";
		}
	}



  // verify customer personal details

	public String verifyCustomerPersonalDeatils(CustomerDto customer)  throws InvalidValuesException{
		List<Customer> customers =customerRepository.findByFirstNameAndLastName(customer.getFirstName(),customer.getLastName());
		if(customers.isEmpty())
		{
			 throw new InvalidValuesException("No customer found for the provided details" );

		}
		else
		{
			for(int i=0;i<customers.size();i++)
			{
			if(!customers.get(i).getEmailAddress().equals(customer.getEmailAddress()))
			{
				throw new InvalidValuesException("Invalid email details!!");
			}
			
			
			}
			return "Success";
		}
	
	}


  // update customer address


	public String updateAddress(CustomerDto customerdto) {
		List<Customer> customers = customerRepository.findByEmailAddress(customerdto.getEmailAddress());
		if(customers.get(0).getAddress()==null)
		{
			customers.get(0).setAddress(customerdto.getAddress());
			customerRepository.save(customers.get(0));
             return "New Address is added";
		}
		else
		{
			
			addressRepository.UpdateAddress(customerdto.getAddress().getAddress(), customerdto.getAddress().getCity(),customerdto.getAddress().getPincode(),customerdto.getAddress().getState(), customers.get(0).getAddress().getAddressId());
			
			return "Already existed Updated";
		}
	
	}


	public CustomerDto getCustomerProfile(String id) {
		// TODO Auto-generated method stub
		
		Customer cust = customerRepository.findByUniqueId(id).get(0);
		CustomerDto custDTO = CustomerDto.valueOf(cust);
		return custDTO;
	}
	


	// verify customer identity proof



	public String verifyCustomerIdentity(CustomerDto customer) throws InvalidValuesException,AlreadyActive {
		
		
		List<CustomerIdentity> customersIdentity =  customerIdentityRepository.findByUniqueId(customer.getuniqueId());
		if((customer.getFirstName().toLowerCase().equals(customersIdentity.get(0).getFirstName().toLowerCase())) && (customer.getLastName().toLowerCase().equals(customersIdentity.get(0).getLastname().toLowerCase())) )
		{
			if((customer.getDateOfBirth().equals(customersIdentity.get(0).getDateOfbirth())) && (customer.getEmailAddress().toLowerCase().equals(customersIdentity.get(0).getEmailAddress().toLowerCase())) )
			{
				
				System.out.println(customer.getDetails().getSimId());
				
				if(customer.getDetails().getSimStatus().equals("InActive"))
				{
					
				    
					return "update";
				}
				else
				{
					return "Sim Already Activated";
				}
			}
			else
			{
				throw new InvalidValuesException("Incorrect date of birth details");

			}
		}
		else
		{
			
			throw new InvalidValuesException("Invalid details");
		}
	}

}



	

