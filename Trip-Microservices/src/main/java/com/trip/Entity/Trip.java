package com.trip.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRIP_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
	
	    @Id
	    private String id;                  
	    private String destination; 
	   
	    @CreatedBy
	    private LocalDateTime startDate;
	    @CreatedBy
	    private LocalDateTime endDate; 
	    private String tripType;
	    private BigDecimal price; 
	    

}
