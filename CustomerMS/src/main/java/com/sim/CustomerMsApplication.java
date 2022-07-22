package com.sim;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@EnableFeignClients(basePackages = {"com.sim.controller"})
@SpringBootApplication
public class CustomerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMsApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
