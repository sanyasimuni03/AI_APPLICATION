package com.destination.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.destination.Entity.Destination;

@Repository
public interface DestinationRepository  extends JpaRepository<Destination, String>{

	
}
