package com.destination.Controller;

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

import com.destination.DTO.DestinationResponse;
import com.destination.Exception.ApiResponse;
import com.destination.Service.DestinationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/destination")
public class DestinationController {
	@Autowired
	private DestinationService destinationService;
	
	
	@PostMapping("/add")
	public ResponseEntity<DestinationResponse>addDestination(@Valid @RequestBody DestinationResponse destinationResponse){
	
		DestinationResponse resp=this.destinationService.addDestination(destinationResponse);
		
		return new ResponseEntity<DestinationResponse>(resp,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DestinationResponse>SingleDestination(@PathVariable String id){
	
		DestinationResponse resp=this.destinationService.DestinationfindById(id);
		
		return new ResponseEntity<DestinationResponse>(resp,HttpStatus.OK);
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<List<DestinationResponse>>ListDestination(){
	
		List<DestinationResponse> resp=this.destinationService.listOfDestination();
		
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse>DeleteDestination(@PathVariable String id){
	
		this.destinationService.DeleteDestination(id);
		
		return new ResponseEntity<>(new ApiResponse("Delete Success!",true),HttpStatus.OK);
	}
	
	
	

}
