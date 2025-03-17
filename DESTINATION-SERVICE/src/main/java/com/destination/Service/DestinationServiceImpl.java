package com.destination.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.destination.DTO.DestinationResponse;
import com.destination.Entity.Destination;
import com.destination.Exception.DestinationIdNotFoundException;
import com.destination.Repo.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService{

	@Autowired
	private DestinationRepository repository;
	
	@Autowired
	private ModelMapper  mapper;
	
	
	
	
	@Override
	public DestinationResponse addDestination(DestinationResponse destinationResponse) {
		
		  Destination dest=this.mapper.map(destinationResponse, Destination.class);
		  
		       dest.setId(UUID.randomUUID().toString());
		      
		            Destination saved= this.repository.save(dest);
		
		
		return this.mapper.map(saved, DestinationResponse.class);
	}

	@Override
	public DestinationResponse DestinationfindById(String id) {
		
	     Destination des=this.repository.findById(id).orElseThrow(()->new DestinationIdNotFoundException("Destination Not Found !"));

		
		return this.mapper.map(des, DestinationResponse.class);
	}

	@Override
	public List<DestinationResponse> listOfDestination() {

                 List<Destination>list=this.repository.findAll();
                List<DestinationResponse>resp= list.stream().map((e)->this.mapper.map(e, DestinationResponse.class)).collect(Collectors.toList());
		return resp;
	}

	@Override
	public void DeleteDestination(String id) {
		

	     Destination des=this.repository.findById(id).orElseThrow(()->new DestinationIdNotFoundException("Destination Not Found !"));
	     repository.delete(des);
		
	}
	
	
	//modelMapper
	
	
	public Destination DestToDto(DestinationResponse destinationResponse) {
		
		return this.mapper.map(destinationResponse, Destination.class);
		
	}
	
	public DestinationResponse DtoToDestination(Destination destinationResponse) {
		
		return this.mapper.map(destinationResponse, DestinationResponse.class);
		
	}
}
