package model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    String id;
    private int noOfFloors;
    private int noOfSlotsPerFloor;
    List<Floor> floors;

    public ParkingLot(String id, int noOfFloors, int noOfSlotsPerFloor) {
        this.id = id;
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        this.floors = new ArrayList<>(noOfFloors);
    }

   public int getNoOfFloors() {
        return noOfFloors;
    }

    public int getNoOfSlotsPerFloor() {
        return noOfSlotsPerFloor;
    }

    public String getId(){
        return id;
    }


}
