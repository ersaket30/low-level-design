package controller;


import model.Location;
import model.User;
import service.RiderService;
import service.TripService;

public class RiderController {

    RiderService riderService;
    TripService tripService;

    RiderController(RiderService riderService){
        this.riderService=riderService;
    }

    void registerRider(User rider){
        riderService.registerRider(rider);
    }

    public String createTrip(
            final String riderId,
            final Double sourceX,
            final Double sourceY,
            final Double destX,
            final Double destY) {

        tripService.createTrip(
                riderId,
                new Location(sourceX, sourceY),
                new Location(destX, destY));

        return "Ride Created";
    }




}
