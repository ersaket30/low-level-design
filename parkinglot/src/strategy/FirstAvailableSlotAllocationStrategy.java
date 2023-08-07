package strategy;

import model.Slot;
import model.VehicleType;
import repository.ParkingDataRepository;

import java.util.List;

public class FirstAvailableSlotAllocationStrategy implements SlotAllocationStrategy{

    ParkingDataRepository parkingDataRepository;

    public FirstAvailableSlotAllocationStrategy(ParkingDataRepository parkingDataRepository){
        this.parkingDataRepository = parkingDataRepository;
    }

    @Override
    public Slot getSlot(VehicleType type) {
        List<Slot> slots = parkingDataRepository.getSlots();
        return slots.stream().filter(slot -> slot.isAvailable() && slot.getType().equals(type)).findFirst().orElse(null);
    }
}
