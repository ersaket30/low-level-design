package service;

import model.DisplayType;
import model.Floor;
import model.ParkingLot;
import model.Slot;
import model.Vehicle;
import model.VehicleType;
import repository.ParkingDataRepository;
import strategy.SlotAllocationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParkingLotService {

    ParkingDataRepository parkingDataRepository;
    ParkingLot parkingLot;
    HashMap<String, Vehicle> ticketVehicleMap;
    SlotAllocationStrategy slotAllocationStrategy;

    public ParkingLotService(SlotAllocationStrategy slotAllocationStrategy,
                             ParkingDataRepository parkingDataRepository){
        this.ticketVehicleMap = new HashMap<>();
        this.slotAllocationStrategy = slotAllocationStrategy;
        this.parkingDataRepository = parkingDataRepository;
    }

    public void createParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        parkingDataRepository.initialiseParkingData(parkingLot.getNoOfFloors(),
                parkingLot.getNoOfSlotsPerFloor());
    }

    public void parkVehicle(VehicleType type, String registrationNo, String color) {
        Slot slot = slotAllocationStrategy.getSlot(type);

        if (Objects.isNull(slot)) {
            System.out.println("Parking Lot Full " + "Slot not available for vehicle type" + type);
        } else {
            slot.setIsAvailable(false);
            Vehicle vehicle = new Vehicle(type, registrationNo, color, slot);
            String ticketId = generateTicket(parkingLot.getId(), slot.getFloorId(), slot.getId());
            ticketVehicleMap.put(ticketId, vehicle);
            System.out.println("Parked vehicle." + "Ticket ID: " + ticketId);
        }
    }

    public void unParkVehicle(String ticketId) {
        Vehicle vehicle = ticketVehicleMap.get(ticketId);

        if (Objects.isNull(vehicle)) {
            System.out.println("Invalid Ticket");
        } else {
            Slot slot = vehicle.getSlot();
            slot.setIsAvailable(true);
            System.out.println("Unparked vehicle with Registration Number: "
                    + vehicle.getRegistrationNumber() + "+and Color: " +
                    vehicle.getColor());
            ticketVehicleMap.remove(ticketId);
        }
    }

    public void display(DisplayType displayType, VehicleType vehicleType) {
        if (displayType == DisplayType.FREE_COUNT) {
            displayFreeCount(vehicleType);
        } else if (displayType == DisplayType.FREE_SLOTS) {
            displaySlots(vehicleType, true);
        } else if (displayType == DisplayType.OCCUPIED_SLOTS) {
            displaySlots(vehicleType, false);
        } else {
            System.out.println("INVALID DISPLAY");
        }
    }


    private void displaySlots(VehicleType vehicleType, boolean isFree) {
        List<Floor> floors = parkingDataRepository.getFloors();
        for (Floor floor : floors) {
            String slotIds = floor.getSlots().stream().filter(slot -> slot.isAvailable() == isFree && slot.getType().equals(vehicleType)).map(slot -> String.valueOf(slot.getId())).
                    collect(Collectors.joining(","));
            System.out.println("Free slots for " + vehicleType.name() + " on Floor " + floor.getId() + ": " + slotIds);
        }
    }

    private void displayFreeCount(VehicleType vehicleType) {
        List<Floor> floors = parkingDataRepository.getFloors();
        for (Floor floor : floors) {
            long count = floor.getSlots().stream().filter(slot -> slot.isAvailable() && slot.getType().equals(vehicleType)).count();
            System.out.println("No. of free slots for " + vehicleType.name() + " on Floor " + floor.getId() + ": " + count);
        }
    }

    private String generateTicket(String id, int floorId, int id1) {
        return id + "_" + floorId + "_" + id1;
    }
}
