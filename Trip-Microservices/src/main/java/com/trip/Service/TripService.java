package com.trip.Service;

import java.util.List;

import com.trip.DTO.TripResponse;

public interface TripService {
	
	public TripResponse addTrip(TripResponse trip);
	
	public TripResponse singleTripById(String id);
	
	public String delete(String id);
	
	public List<TripResponse> listofTrip();
	

}
