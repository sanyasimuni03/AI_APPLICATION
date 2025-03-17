package com.trip.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TripResponse {
	
	   // Ensures that the ID is not null
	    private String id;

	    @NotNull(message = "Destination cannot be null") // Ensures that destination is not null
	    @Size(min = 2, max = 100, message = "Destination must be between 2 and 100 characters") // Ensures that destination has a valid length
	    private String destination;
	    private LocalDateTime startDate;
	    private LocalDateTime endDate;

	    @NotNull(message = "Price cannot be null") // Ensures that price is not null
	    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0") // Ensures that price is greater than 0
	    private BigDecimal price;
	    
	    @Pattern(regexp = "BUSINESS|NORMAL", message = "Trip type must be either BUSINESS or NORMAL")
	    private String tripType;


}
