package com.simMS.Service;

import java.util.List;

import com.simMS.DTO.SimDetailsDTO;
import com.simMS.Entity.SimOffers;
import com.simMS.Exception.SimCardNotValidatedException;

public interface SimDetailsService {

	
	public void insertRecord(SimDetailsDTO dto) throws Exception;
	public List<SimOffers> getOffersByValidation(SimDetailsDTO dto) throws SimCardNotValidatedException;
	
}
