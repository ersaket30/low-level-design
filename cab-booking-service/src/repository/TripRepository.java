package repository;

import model.Trip;

import java.util.HashMap;
import java.util.Map;

public class TripRepository {

    Map<String, Trip> trips = new HashMap<>();

    void addTrip(Trip trip){
        trips.put(trip.getRider().getId(),trip);
    }



}
