package com.trip.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trip.DTO.TripResponse;
import com.trip.Entity.Trip;
import com.trip.Exception.ResourceNotFoundException;
import com.trip.Repo.TripRepository;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	private TripRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	
	@Override
	public TripResponse addTrip(TripResponse trip) {
		
		     Trip t= this.mapper.map(trip, Trip.class);
		       t.setId(UUID.randomUUID().toString());
		       t.setStartDate(LocalDateTime.now());
		       t.setEndDate(LocalDateTime.now());
		         Trip saved= repository.save(t);
		
		
		return this.mapper.map(saved,TripResponse.class);
	}

	@Override
	public TripResponse singleTripById(String id) {
		
		  Trip trip=this.repository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID Not found !"));
		return this.mapper.map(trip, TripResponse.class);
	}

	@Override
	public String delete(String id) {
		
		 Trip trip=this.repository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID Not found !"));
			 repository.delete(trip);
			return "Delete Id Success";
	}

	@Override
	public List<TripResponse> listofTrip() {
		
		      List<Trip>trip=this.repository.findAll();
		      List<TripResponse>reesp=trip.stream().map((er)->this.mapper.map(er, TripResponse.class)).collect(Collectors.toList());
		
		return reesp;
	}
	
	

	public Trip TripResponseToTrip(TripResponse response) {
        return this.mapper.map(response, Trip.class);  // Mapping from TripResponse to Trip
    }

    // Convert Trip to TripResponse
    public TripResponse TripToTripResponse(Trip trip) {
        return this.mapper.map(trip, TripResponse.class);  // Mapping from Trip to TripResponse
    }


}
