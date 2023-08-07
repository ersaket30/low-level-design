import model.Command;
import model.DisplayType;
import model.ParkingLot;
import model.VehicleType;
import repository.ParkingDataRepository;
import service.ParkingLotService;
import strategy.FirstAvailableSlotAllocationStrategy;
import strategy.SlotAllocationStrategy;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        ParkingDataRepository parkingDataRepository = new ParkingDataRepository();
        SlotAllocationStrategy slotAllocationStrategy = new FirstAvailableSlotAllocationStrategy(parkingDataRepository);
        ParkingLotService parkingLotService = new ParkingLotService(slotAllocationStrategy,parkingDataRepository);

        while (true) {
            Scanner scan = new Scanner(System.in);
            Command type = Command.of(scan.next());
            switch (type) {
                case CREATE_PARKING_LOT:
                    parkingLotService.createParkingLot(new ParkingLot(scan.next(), scan.nextInt(), scan.nextInt()));
                    break;
                case PARK_VEHICLE:
                    parkingLotService.parkVehicle(VehicleType.valueOf(scan.next()), scan.next(), scan.next());
                    break;
                case UNPARK_VEHICLE:
                    parkingLotService.unParkVehicle(scan.next());
                    break;
                case DISPLAY:
                    parkingLotService.display(DisplayType.of(scan.next()), VehicleType.valueOf(scan.next()));
                    break;
                case EXIT:
                    return;
            }
        }
    }
}
