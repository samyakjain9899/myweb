package com.customerMS.Controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerMS.DTO.CustomerDTO;
import com.customerMS.DTO.CustomerValidateDTO;
import com.customerMS.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	
	/**
	 * 3RD CASE
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/validateDetails")
	public ResponseEntity<Object> validateDetails(@RequestBody @Valid CustomerValidateDTO dto ) throws Exception{
		
		
	
		String msg = customerService.validate(dto);
		
		HashMap<String,Object> hashmap = new HashMap<>();
		hashmap.put("data",msg);
		
	
		return ResponseEntity.ok(hashmap);
		
	}
	
	@PostMapping("/idproofvalidation")
	public ResponseEntity<Object> checkForIDProofAndActivate(@RequestBody @Valid CustomerDTO customerDTO) throws Exception{
		
		Object dataFromService =  customerService.validateIDProofAndActivate(customerDTO);
		
		return ResponseEntity.ok(dataFromService);
		
	}

}
