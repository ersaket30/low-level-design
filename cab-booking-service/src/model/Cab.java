package model;

import java.util.UUID;

public class Cab {
    String id;
    String driverName;

    Boolean isAvailable;

    Location currentLocation;

    Trip currentTrip;

    public String getId() {
        return id;
    }

    public String getDriverName() {
        return driverName;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Cab(String id,String driverName){
        this.id = id;
        this.driverName=driverName;
        this.isAvailable = true;
    }
}
