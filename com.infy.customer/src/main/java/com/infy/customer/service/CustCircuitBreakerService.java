package com.infy.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.vavr.concurrent.Future;

import com.infy.customer.dto.SimDetailsDTO;

@Service
public class CustCircuitBreakerService {
	@Autowired
	RestTemplate template;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@CircuitBreaker(name="simService", fallbackMethod="getSimDetailsFallback")
	public Future<SimDetailsDTO> getSimDetails(Integer simId) {
		List<ServiceInstance> instances = discoveryClient.getInstances("SimMS");
		String simUri = instances.get(0).getUri().toString() + "/sim/details";
		return Future.of(()->template.getForObject(simUri+"/"+ simId, SimDetailsDTO.class));
	}
	
	public SimDetailsDTO getSimDetailsFallback(Integer simId, Throwable throwable) {
		return new SimDetailsDTO();
	}
}
