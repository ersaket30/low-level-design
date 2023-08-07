package repository;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class RiderRepository {

    Map<String,User> riders = new HashMap<>();
    public void addRider(User rider) {
        riders.put(rider.getId(),rider);
    }
}
