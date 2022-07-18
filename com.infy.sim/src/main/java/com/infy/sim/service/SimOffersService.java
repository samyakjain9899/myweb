package com.infy.sim.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.sim.dto.SimOffersDTO;
import com.infy.sim.entity.SimDetails;
import com.infy.sim.entity.SimOffers;
import com.infy.sim.exception.SimIdNotFoundException;
import com.infy.sim.exception.SimOfferNotFoundException;
import com.infy.sim.repository.SimDetailsRepository;
import com.infy.sim.repository.SimOffersRepository;

@Service
@Transactional
public class SimOffersService {
	@Autowired
	SimOffersRepository simOffersRepository;
	@Autowired
	SimDetailsRepository simDetailsRepository;
	@Autowired
	private Environment environment;
	
	public List<SimOffersDTO> getAllSimOffers() {
		List<SimOffers> simOffers = simOffersRepository.findAll();
		List<SimOffersDTO> simOffersDTO = simOffers.stream().map(i->i.convertEntityToDto()).toList();
		return simOffersDTO;
	}
	
	public SimOffersDTO getSimOfferById(Integer offerId) throws SimOfferNotFoundException {
		Optional<SimOffers> simOffers = simOffersRepository.findById(offerId);
		if(simOffers.isPresent()) {
			SimOffersDTO simOffersDTO = simOffers.get().convertEntityToDto();
			return simOffersDTO;
		}
		throw new SimOfferNotFoundException(environment.getProperty("sim_offer_not_found"));
	}
	
	public void addSimOffers(SimOffersDTO simOffersDTO) throws SimIdNotFoundException{
		SimOffers simOffers = simOffersDTO.convertDtoToEntity();
		Optional<SimDetails> simDetails = simDetailsRepository.findById(simOffersDTO.getSimDetails().getSimId());
		if(simDetails.isPresent()) {
			simOffers.setSimDetails(simDetails.get());
			simOffersRepository.save(simOffers);
		} else {
			throw new SimIdNotFoundException(environment.getProperty("simid_not_found"));
		}
	}
}
