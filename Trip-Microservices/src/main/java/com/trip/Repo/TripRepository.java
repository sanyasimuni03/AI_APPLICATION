package com.trip.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trip.Entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip,String> {

}
