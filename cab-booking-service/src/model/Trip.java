package model;

public class Trip {

    Cab cab;
    User rider;

    Location source;
    Location destination;
    TripStatus status;

    public User getRider() {
        return rider;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

}
