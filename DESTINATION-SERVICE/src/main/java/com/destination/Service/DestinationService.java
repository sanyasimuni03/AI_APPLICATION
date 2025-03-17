package com.destination.Service;

import java.util.List;

import com.destination.DTO.DestinationResponse;

public interface DestinationService {
	
	public DestinationResponse addDestination(DestinationResponse destinationResponse);
	
	public DestinationResponse DestinationfindById(String id);
	
	public List<DestinationResponse>listOfDestination();
	
	public void DeleteDestination(String id);
	
	
	

}
