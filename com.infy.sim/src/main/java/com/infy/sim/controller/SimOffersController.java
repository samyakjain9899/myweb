package com.infy.sim.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.sim.dto.SimOffersDTO;
import com.infy.sim.exception.SimIdNotFoundException;
import com.infy.sim.exception.SimOfferNotFoundException;
import com.infy.sim.service.SimOffersService;


@RestController
@RequestMapping("/sim/offers")
@Validated
@CrossOrigin
public class SimOffersController {
	@Autowired
	SimOffersService simOffersService;
	@Autowired
	private Environment environment;
	
	
	@GetMapping
	public ResponseEntity<List<SimOffersDTO>> getAllSimOffers() {
		return ResponseEntity.ok().body(simOffersService.getAllSimOffers());
	}
	
	@GetMapping("/{offerId}")
	public ResponseEntity<SimOffersDTO> getSimOfferById(@PathVariable Integer offerId) throws SimOfferNotFoundException {
		return ResponseEntity.ok().body(simOffersService.getSimOfferById(offerId));
	}
	
	@PostMapping
	public ResponseEntity<String> addSimOffers(@Valid @RequestBody SimOffersDTO simOffersDTO) throws SimIdNotFoundException {
		simOffersService.addSimOffers(simOffersDTO);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(environment.getProperty("sim_offers_added_success"),HttpStatus.CREATED);
		return responseEntity;
	}
}
