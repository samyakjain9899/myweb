package com.sim.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sim.dto.SimDetailsDto;


@FeignClient(name = "SimMS", url="http://localhost:9200/")
public interface CustomerSimFine {
	@RequestMapping("/simportal/{simId}")
	SimDetailsDto getSpecificFriends(@PathVariable("simId") int simId);
	
	@RequestMapping(method = RequestMethod.PUT,value="/simportal/simstatus/{simId}")
	String updateSimStatus(@PathVariable("simId") int simId);
}
