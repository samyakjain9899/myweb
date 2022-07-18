package com.simMS.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.simMS.DTO.SimDetailsDTO;
import com.simMS.Entity.SimDetails;
import com.simMS.Entity.SimOffers;
import com.simMS.Exception.SimCardNotValidatedException;
import com.simMS.Repository.SimDetailsRepository;


@Service("SimdetailsService")
public class SimDetailService implements SimDetailsService{

	private SimDetailsRepository simDetailsRepository;
    @Autowired
	public void setSimDetailsRepository(SimDetailsRepository simDetailsRepository) {
		this.simDetailsRepository = simDetailsRepository;
	}



	@Override
	public void insertRecord(SimDetailsDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
//		List<SimDetails> details = simDetailsRepository.findAll();
//		System.out.println("list"+details);

		//check for PAIR VALIDATION
		List<SimDetails> detailsList = simDetailsRepository.checkForPair(dto.getSimNumber(),dto.getServiceNumber());
		
		
		System.out.println("VALUE"+detailsList);
		
		 if(!detailsList.isEmpty()) {
			 
			 throw new Exception("CAN'T ADD AS RECORD ALREADY EXISTS");
		 }
		
			 
			 SimDetails simDetails = SimDetailsDTO.convertDTOToEntity(dto);
			 simDetailsRepository.save(simDetails);
			 
		
		
		
	}


    @Override
	public List<SimOffers> getOffersByValidation(SimDetailsDTO dto) throws SimCardNotValidatedException {
		// TODO Auto-generated method stub

		Optional<SimDetails> optSimCardDetails = simDetailsRepository.checkForBoth(dto.getSimNumber(), dto.getServiceNumber());
		
		
		if(optSimCardDetails.isEmpty() || !optSimCardDetails.get().getSimStatus()) {
			throw new SimCardNotValidatedException("NOT VALID DETAILS");
		}
		
	
		List<SimOffers> offers = optSimCardDetails.get().getOffers();
		
	    return offers;
	    
	}
    
    /////////////////////////////////////////////////////////////////////////////////////
	/*
	 * public static Integer getRandomNumberUsingNextInt(int min, int max) { Random
	 * random = new Random(); return random.nextInt(max - min) + min; }
	 * 
	 * 
	 * List<SimDetails> availableSimCards =
	 * simDetailsRepository.findRandomlyAndActivate();
	 */
	
	
	//GIVE ONLY THOSE SIM WHICH HAVE OFFERS
	
	/*
	 * List<SimDetails> filterWithAvailableOffers =
	 * availableSimCards.stream().filter(
	 * 
	 * sim-> sim.getOffers().size()>=1
	 * 
	 * ).toList(); int size = filterWithAvailableOffers.size() ;
	 * 
	 * if(size==0) { throw new
	 * Exception("NO SIMCARD AVAILABLE /OFFERS. CONTACT SERVICE PROVIDER"); }
	 * 
	 * int generateRnadomNumberInRange =
	 * SimDetailService.getRandomNumberUsingNextInt(0,size);
	 * 
	 * if(generateRnadomNumberInRange <0) { throw new Exception("Out of Range"); }
	 * 
	 * 
	 * SimDetails simToBeAlloted =
	 * filterWithAvailableOffers.get(generateRnadomNumberInRange);
	 * 
	 * 
	 * //ACTIVATE THE SIM
	 * 
	 * 
	 * simToBeAlloted.setSimStatus(true);
	 * 
	 * simDetailsRepository.save(simToBeAlloted);
	 */

//    @Override
//	public List<SimOffers> getOffersByValidation(SimDetailsDTO dto) throws SimCardNotValidatedException {
//		// TODO Auto-generated method stub
//		
//		
//			Optional<SimDetails> optSimCardDetails = simDetailsRepository.checkForBoth(dto.getSimNumber(), dto.getServiceNumber());
//			if(optSimCardDetails.isEmpty()) {
//				throw new SimCardNotValidatedException("NOT VALID DETAILS");
//			}
//			
//			List<SimOffers> offers = optSimCardDetails.get().getOffers();
//			
//		    return offers;
//	}

 // FIND THE SIM WHICH IS AVAILABLE AND CURRENTLY NOT ACTIVE
	
 			List<SimDetails> availableSimCards = simDetailsRepository.findRandomlyAndActivate();
 			
 			//GIVE ONLY THOSE SIM WHICH HAVE OFFERS
 			
 			List<SimDetails> filterWithAvailableOffers = availableSimCards.stream().filter(
 					
 					sim-> sim.getOffers().size()>=1
 					
 					).toList();
 			
            int size = filterWithAvailableOffers.size();
			
			if(size==0) {
				throw new Exception("NO SIMCARD AVAILABLE /OFFERS. CONTACT SERVICE PROVIDER");
			}
			
			
		 
			//GET THE SIM NOW FROM THE RANDOM INDEX
			
			
			
			
			//ACTIVATE THE SIM
		
			
			
 			




}
