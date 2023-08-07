package service;

import model.Location;
import model.User;
import repository.RiderRepository;

public class RiderService {
    RiderRepository riderRepository;
    public void registerRider(User rider){
        riderRepository.addRider(rider);
    }

    public void createTrip(String riderId, Location source,Location destination){

    }
}
