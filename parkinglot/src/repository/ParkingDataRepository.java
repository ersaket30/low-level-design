package repository;

import model.Floor;
import model.Slot;
import model.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingDataRepository {

    List<Floor> floors;
    List<Slot> slots;

    public List<Floor> initialiseParkingData(int noOfFloors, int noOfSlots) {
        floors = new ArrayList<>(noOfFloors);
        slots = new ArrayList<>();
        for (int i = 1; i <= noOfFloors; i++) {
            List<Slot> slots = initialiseSlots(noOfSlots, i);
            floors.add(new Floor(i, slots));
            this.slots.addAll(slots);
        }
        return floors;
    }

    private List<Slot> initialiseSlots(int noOfSlots, int floorId) {
        List<Slot> slots = new ArrayList<>();
        if (noOfSlots >= 1)
            slots.add(new Slot(1, floorId, VehicleType.TRUCK));
        if (noOfSlots >= 3)
            for (int i = 2; i <= 3; i++)
                slots.add(new Slot(i, floorId, VehicleType.BIKE));
        for (int i = 4; i <= noOfSlots; i++)
            slots.add(new Slot(i, floorId, VehicleType.CAR));
        return slots;
    }

    public List<Slot> getSlots() {
        return slots;
    }
    public List<Floor> getFloors() {
        return floors;
    }
}
