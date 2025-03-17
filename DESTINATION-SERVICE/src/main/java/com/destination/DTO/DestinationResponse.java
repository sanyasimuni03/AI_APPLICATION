package com.destination.DTO;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DestinationResponse {

	
	       private String id;
	       @NotBlank(message = "Name is required")
	       @Size(max = 100, message = "Name must be less than 100 characters")
	       private String name;

	       @NotBlank(message = "Country is required")
	       @Size(max = 100, message = "Country must be less than 100 characters")
	       private String country;

	       @Size(max = 100, message = "Region must be less than 100 characters")
	       private String region;

	       @NotBlank(message = "Destination Type is required")
	       @Pattern(regexp = "Beach|Mountain|Urban|Cultural", 
	                message = "Destination Type must be one of: Beach, Mountain, Urban, Cultural")
	       private String destinationType;

	       @Size(max = 500, message = "Description must be less than 500 characters")
	       private String description;

	       @DecimalMin(value = "-90.0", message = "Latitude must be between -90.0 and 90.0")
	       @DecimalMax(value = "90.0", message = "Latitude must be between -90.0 and 90.0")
	       private Double latitude;

	       @DecimalMin(value = "-180.0", message = "Longitude must be between -180.0 and 180.0")
	       @DecimalMax(value = "180.0", message = "Longitude must be between -180.0 and 180.0")
	       private Double longitude;

	       @Positive(message = "Average Cost must be a positive value")
	       private Double averageCost;

	       @Pattern(regexp = "Summer|Winter|Spring|Autumn", 
	                message = "Best Season must be one of: Summer, Winter, Spring, Autumn")
	       private String bestSeason;

	      
	   

}
