package controller;

import model.Cab;
import model.Location;
import service.CabService;

public class CabController {
    CabService cabService;
    TripService tripService;

    public String registerCab(final String id,final String driverName) {
        cabService.createCab(new Cab(id,driverName));
        return "Cab Registered";
    }

    public String updateCabLocation(
            final String cabId, final Double newX, final Double newY) {

        cabService.updateCabLocation(cabId, new Location(newX, newY));
        return "Cab Location Updated";
    }

    public String updateCabAvailability(final String cabId, final Boolean newAvailability) {
        cabService.updateCabAvailability(cabId, newAvailability);
        return "Cab Availability updated";
    }

    public String endTrip(final String cabId) {
        cabService.endTrip(cabId);
        return ResponseEntity.ok("");
    }
}
