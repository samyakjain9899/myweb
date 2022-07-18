package com.customerMS.Controller;

import java.util.HashMap;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerMS.DTO.AddressDTO;
import com.customerMS.Service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/add")
	public ResponseEntity<Object> addAddress(@RequestBody @Valid AddressDTO address) throws Exception{
		
		
		String message = addressService.addAddress(address);
		
		HashMap<String,Object> hm = new HashMap<>();
		hm.put("data",message);
		
		return ResponseEntity.ok(hm);
		
	}
}
