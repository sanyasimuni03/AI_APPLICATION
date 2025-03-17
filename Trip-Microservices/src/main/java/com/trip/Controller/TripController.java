package com.trip.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.DTO.TripResponse;
import com.trip.Service.TripService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/trip")
public class TripController {
	
	@Autowired
	private TripService tripService;
	
	
	@PostMapping("/req")
	public ResponseEntity<TripResponse>AddTripDetails(@Valid  @RequestBody TripResponse response){
	
		              TripResponse trip=tripService.addTrip(response);	
		              
		              return new ResponseEntity<>(trip,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/findList")
	public ResponseEntity<List<TripResponse>>ListOfTripDetails(){
	
		              List<TripResponse> trip=tripService.listofTrip();	
		              
		              return new ResponseEntity<>(trip,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<TripResponse>SingleTripDetails(@PathVariable String id){
	
		              TripResponse trip=tripService.singleTripById(id);	
		              
		              return new ResponseEntity<>(trip,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>DeleteTripDetails(@PathVariable String id){
		
		                    String resp= (String) tripService.delete(id);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	     
		           
	

	}
	
	

}
