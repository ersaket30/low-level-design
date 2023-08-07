package model;

import java.util.List;

public class Floor {

    private int id;
    private List<Slot> slots;

    public Floor(int floorId, List<Slot> slots) {

        this.id = floorId;
        this.slots = slots;
    }


    public List<Slot> getSlots() {
        return slots;
    }

    public int getId() {
        return id;
    }
}
