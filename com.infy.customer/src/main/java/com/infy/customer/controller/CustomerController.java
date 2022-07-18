package com.infy.customer.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.infy.customer.dto.CustomerDTO;
import com.infy.customer.dto.SimDetailsDTO;
import com.infy.customer.exception.AadharNumberInvalidException;
import com.infy.customer.exception.CustomerNotFoundException;
import com.infy.customer.exception.CustomerValidationFailedException;
import com.infy.customer.exception.DateOfBirthInvalidException;
import com.infy.customer.exception.EmailAddressInvalidException;
import com.infy.customer.exception.FirstNameLastNameInvalidException;
import com.infy.customer.exception.InvalidCustomerAddressSimDetailsException;
import com.infy.customer.exception.SimAlreadyActiveException;
import com.infy.customer.exception.SimIdNotFoundException;
import com.infy.customer.service.CustomerService;


@RestController
@RequestMapping("/customer")
@Validated
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	private Environment environment;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
		return ResponseEntity.ok().body(customerService.getAllCustomer());
	}
	
	@GetMapping("uid/{uniqueIdNumber}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String uniqueIdNumber) throws CustomerNotFoundException {
		return ResponseEntity.ok().body(customerService.getCustomerById(uniqueIdNumber));
	}
	
	@PutMapping("/{aadharNumber}/{firstName}/{lastName}/{dateOfBirth}")
	public ResponseEntity<String> verifyCustomerAndActiveSim(@PathVariable 
									@Size(min=16, max=16)
									@Pattern(regexp="[0-9]{16}")
									String aadharNumber, 
									@PathVariable String firstName,
									@PathVariable String lastName,
									@DateTimeFormat(pattern = "yyyy-MM-dd")
									@PathVariable LocalDate dateOfBirth) throws MethodArgumentTypeMismatchException, SimAlreadyActiveException, 
											DateOfBirthInvalidException, FirstNameLastNameInvalidException, AadharNumberInvalidException, SimIdNotFoundException {
		String responseMessage = customerService.verifyCustomerAndActivateSim(aadharNumber, firstName, lastName, dateOfBirth);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(responseMessage,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws InvalidCustomerAddressSimDetailsException{
		ResponseEntity<String> responseEntity = null;
		List<ServiceInstance> instances = discoveryClient.getInstances("SimMS");
		String simUri = instances.get(0).getUri().toString() + "/sim/details";
		SimDetailsDTO simDetailsDTO = new RestTemplate().getForObject(simUri+"/"+customerDTO.getSimId(), SimDetailsDTO.class);
		if(simDetailsDTO.getSimId() != null) {
			 Map < String, String > params = new HashMap < String, String > ();
		     params.put("simId", customerDTO.getSimId().toString());
		     params.put("uniqueIdNumber", customerDTO.getUniqueIdNumber());
			new RestTemplate().put(simUri+ "/{simId}/uid/{uniqueIdNumber}", new SimDetailsDTO(), params);
			customerService.addCustomer(customerDTO);
			responseEntity = new ResponseEntity<>(environment.getProperty("customer_added_success"),HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<>(environment.getProperty("simid_not_found"),HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@GetMapping("/{email}/{dateOfBirth}")
	public ResponseEntity<String> validateCustomerBasicDetails(@PathVariable 
								@NotBlank(message="Email value is required")
								@Pattern(regexp="[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message="Invalid email")
								String email, @PathVariable
								@DateTimeFormat(pattern = "yyyy-MM-dd")
								LocalDate dateOfBirth) throws MethodArgumentTypeMismatchException, CustomerValidationFailedException{
		String responseMessage = customerService.validateCustomerBasicDetails(email, dateOfBirth);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(responseMessage,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/{firstName}/{lastName}/{confirmEmail}")
	public ResponseEntity<String> validateCustomerPersonalDetails(@PathVariable
								@Pattern(regexp="[A-Za-z]{1,15}", 
									message="Firstname should contains only alphabets and will be of maximum 15 characters")
								String firstName, @PathVariable  
								@Pattern(regexp="[A-Za-z]{1,15}", 
									message="Lastname should contains only alphabets and will be of maximum 15 characters")
								String lastName, @PathVariable 
								@NotBlank(message="Email value is required")
								@Pattern(regexp="[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message="Invalid email")
								String confirmEmail) throws EmailAddressInvalidException, CustomerNotFoundException{
		String responseMessage = customerService.validateCustomerPersonalDetails(firstName, lastName, confirmEmail);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(responseMessage,HttpStatus.CREATED);
		return responseEntity;
	}

}
