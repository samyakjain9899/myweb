package com.infy.sim.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.sim.dto.SimDetailsDTO;
import com.infy.sim.entity.SimDetails;
import com.infy.sim.exception.SimAlreadyActiveException;
import com.infy.sim.exception.SimServiceNumberInvalidException;
import com.infy.sim.repository.SimDetailsRepository;
import com.infy.sim.repository.SimOffersRepository;

@Service
@Transactional
public class SimDetailsService {
	
	@Autowired
	SimDetailsRepository simDetailsRepository;
	@Autowired
	SimOffersRepository simOffersRepository;
	@Autowired
	private Environment environment;
	
	public List<SimDetailsDTO> getAllSimDetails() {
		List<SimDetails> simDetails = simDetailsRepository.findAll();
		List<SimDetailsDTO> simDetailsDTO = simDetails.stream().map(i->i.convertEntityToDto()).toList();
		return simDetailsDTO;
	}
	
	public SimDetailsDTO getSimDetailsById(Integer simId) {
		SimDetailsDTO simDetailsDTO = null;
		Optional<SimDetails> simDetails = simDetailsRepository.findById(simId);
		if(simDetails.isPresent()) {
			simDetailsDTO = simDetails.get().convertEntityToDto();
		} else {
			simDetailsDTO = new SimDetailsDTO();
		}
		return simDetailsDTO;
	}
	
	public void addSimDetails(SimDetailsDTO simDetailsDTO) {
		SimDetails simDetails = simDetailsDTO.convertDtoToEntity();
		simDetailsRepository.save(simDetails);
	}
	
	public SimDetailsDTO updateUniqueIdNumber(Integer simId, String uniqueIdNumber) {
		Optional<SimDetails> simDetails = simDetailsRepository.findById(simId);
		if(simDetails.isPresent()) {
			simDetails.get().setCustomerUniqueIdNumber(uniqueIdNumber);
			simDetailsRepository.save(simDetails.get());
			return simDetails.get().convertEntityToDto();
		}
		return new SimDetailsDTO();
	}
	
	public SimDetailsDTO updateSimStatus(Integer simId, String simStatus) {
		Optional<SimDetails> simDetails = simDetailsRepository.findById(simId);
		if(simDetails.isPresent()) {
			simDetails.get().setSimStatus(simStatus);
			simDetailsRepository.save(simDetails.get());
			return simDetails.get().convertEntityToDto();
		}
		return new SimDetailsDTO();
	}
	
	public SimDetailsDTO validateSimDetails(String simNumber, String serviceNumber) throws SimAlreadyActiveException, SimServiceNumberInvalidException{
		Optional<SimDetails> simDetails = simDetailsRepository.getSimDetailsBySimNumberAndServiceNumber(simNumber, serviceNumber);
		if(simDetails.isPresent()) {
			if(environment.getProperty("active_txt").equals(simDetails.get().getSimStatus())) {
				throw new SimAlreadyActiveException("SIM already active");
			} else {
				SimDetailsDTO simDetailsDTO = simDetails.get().convertEntityToDto();
				return simDetailsDTO;
			}
		} else {
			throw new SimServiceNumberInvalidException(environment.getProperty("invalid_sim_service_number"));
		}
	}
	
}
