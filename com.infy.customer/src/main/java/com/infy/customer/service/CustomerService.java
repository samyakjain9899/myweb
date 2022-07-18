package com.infy.customer.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.customer.dto.CustomerDTO;
import com.infy.customer.dto.SimDetailsDTO;
import com.infy.customer.entity.Customer;
import com.infy.customer.entity.CustomerAddress;
import com.infy.customer.exception.AadharNumberInvalidException;
import com.infy.customer.exception.CustomerNotFoundException;
import com.infy.customer.exception.CustomerValidationFailedException;
import com.infy.customer.exception.DateOfBirthInvalidException;
import com.infy.customer.exception.EmailAddressInvalidException;
import com.infy.customer.exception.FirstNameLastNameInvalidException;
import com.infy.customer.exception.InvalidCustomerAddressSimDetailsException;
import com.infy.customer.exception.SimAlreadyActiveException;
import com.infy.customer.exception.SimIdNotFoundException;
import com.infy.customer.repository.CustomerAddressRepository;
import com.infy.customer.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerAddressRepository customerAddressRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public List<CustomerDTO> getAllCustomer() {
		List<Customer> customer = customerRepository.findAll();
		List<CustomerDTO> customerDTO = customer.stream().map(i->i.convertEntityToDto()).toList();
		return customerDTO;
	}
	
	public CustomerDTO getCustomerById(String uniqueIdNumber) throws CustomerNotFoundException {
		Optional<Customer> customer = customerRepository.findById(uniqueIdNumber);
		if(customer.isPresent()) {
			CustomerDTO customerDTO = customer.get().convertEntityToDto();
			return customerDTO;
		}
		throw new CustomerNotFoundException(environment.getProperty("invalid_customer"));
	}
	
	public void addCustomer(CustomerDTO customerDTO) throws InvalidCustomerAddressSimDetailsException{
		Customer customer = customerDTO.convertDtoToEntity();
		Optional<CustomerAddress> customerAddress = customerAddressRepository.findById(customerDTO.getCustomerAddress_addressId().getAddressId());
		if(customerAddress.isPresent()) {
			customer.setCustomerAddress_addressId(customerAddress.get());
			customerRepository.save(customer);
		} else {
			throw new InvalidCustomerAddressSimDetailsException(environment.getProperty("invalid_customer_address_id"));
		}
	}
	
	public String validateCustomerBasicDetails(String email, LocalDate dateOfBirth) throws CustomerValidationFailedException {
		Optional<Customer> customer = customerRepository.getCustomerByEmail(email);
		if(customer.isPresent()) {
			if(customer.get().getDateOfBirth().equals(dateOfBirth)) {
				return environment.getProperty("email_dob_valid");
			}
		}
		throw new CustomerValidationFailedException(environment.getProperty("validation_failed"));
	}
	
	public String validateCustomerPersonalDetails(String firstName, String lastName, String confirmemail) throws EmailAddressInvalidException, CustomerNotFoundException  {
		Optional<Customer> customer = customerRepository.getCustomerByFirstNameAndLastName(firstName, lastName);
		if(customer.isPresent()) {
			if(customer.get().getEmailAddress().equals(confirmemail)) {
				return environment.getProperty("valid_customer");
			} else {
				throw new EmailAddressInvalidException(environment.getProperty("invalid_email"));
			}
		}
		throw new CustomerNotFoundException(environment.getProperty("invalid_customer"));
	}
	
	
	public String verifyCustomerAndActivateSim(String aadharNumber, String firstName, String lastName, LocalDate dob) 
				throws SimAlreadyActiveException, DateOfBirthInvalidException, FirstNameLastNameInvalidException, AadharNumberInvalidException, SimIdNotFoundException{
		Optional<Customer> customer = customerRepository.findById(aadharNumber);
		if(customer.isPresent()) {
			if(customer.get().getFirstName().equals(firstName) && customer.get().getLastName().equals(lastName)) {
				if(customer.get().getDateOfBirth().equals(dob)) {
					List<ServiceInstance> instances = discoveryClient.getInstances("SimMS");
					String simUri = instances.get(0).getUri().toString() + "/sim/details";
					SimDetailsDTO simDetailsDTO = new RestTemplate().getForObject(simUri+"/"+customer.get().getSimId(), SimDetailsDTO.class);
					if(simDetailsDTO.getSimId() != null) {
						if(environment.getProperty("active_txt").equals(simDetailsDTO.getSimStatus())) {
							throw new SimAlreadyActiveException(environment.getProperty("sim_already_active"));
						} else {
							Map < String, String > params = new HashMap < String, String > ();
						    params.put("simId", customer.get().getSimId().toString());
						    params.put("simStatus", "active");
							new RestTemplate().put(simUri+ "/{simId}/status/{simStatus}", new SimDetailsDTO(), params);
							return environment.getProperty("sim_activation_success");
						}
					} else {
						throw new SimIdNotFoundException(environment.getProperty("simid_not_found"));
					}
				} else {
					throw new DateOfBirthInvalidException(environment.getProperty("dob_incorrect"));
				}
			} else {
				throw new FirstNameLastNameInvalidException(environment.getProperty("invalid_firstname_lastname"));
			}
		}
		throw new AadharNumberInvalidException(environment.getProperty("invalid_aadhar_number"));
	}
}
