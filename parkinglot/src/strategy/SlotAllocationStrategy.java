package strategy;

import model.Slot;
import model.VehicleType;

public interface SlotAllocationStrategy {

    Slot getSlot(VehicleType type);
}
