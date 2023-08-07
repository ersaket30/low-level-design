package model;

public class Vehicle {

    String registrationNumber;
    VehicleType type;
    String color;
    Slot slot;

    public Vehicle(VehicleType type, String registrationNo, String color,Slot slot) {
        this.type=type;
        this.registrationNumber = registrationNo;
        this.color=color;
        this.slot = slot;
    }

    public Slot getSlot(){
        return slot;
    }
    public String getRegistrationNumber(){
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }
}
