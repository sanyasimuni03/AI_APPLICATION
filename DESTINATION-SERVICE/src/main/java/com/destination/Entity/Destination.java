package com.destination.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "destinations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination {


	    @Id
	    private String id;
	    private String name;
	    private String country;
	    private String region;
	    private String destinationType;
	    private String description;
	    private Double latitude;
	    private Double longitude;
	    private Double averageCost;
	    private String bestSeason;

	   
	


}
