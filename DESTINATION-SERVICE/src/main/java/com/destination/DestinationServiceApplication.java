package com.destination;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class DestinationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DestinationServiceApplication.class, args);
	}

	@Bean
	ModelMapper  modelMapper() {
		return new ModelMapper();
	}
	
}
