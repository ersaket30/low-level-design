package service;

import model.Cab;
import model.Location;
import repository.CabRepository;

public class CabService {
    CabRepository cabRepository;
    public void createCab(Cab cab) {

        cabRepository.addCab(cab);
    }

    public void updateCabLocation(String cabId, Location location) {
        Cab cab = cabRepository.getCabById(cabId);
        cab.setCurrentLocation(location);
    }

    public void updateCabAvailability(String cabId, Boolean newAvailability) {
        Cab cab = cabRepository.getCabById(cabId);
        cab.setAvailable(newAvailability);
    }

    public void endTrip(String cabId) {
        Cab cab = cabRepository.getCabById(cabId);
        cab.setC

    }
}
