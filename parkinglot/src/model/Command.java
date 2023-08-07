package model;

import java.util.HashMap;

public enum Command {

    CREATE_PARKING_LOT("create_parking_lot"),
    DISPLAY("display"),
    PARK_VEHICLE("park_vehicle"),
    UNPARK_VEHICLE("unpark_vehicle"),
    EXIT("exit");

    private final String commandType;

   Command(String commandType){
       this.commandType = commandType;
    }

    private static final HashMap<String, Command> map = new HashMap<>(values().length, 1);

    static {
        for (Command c : values()) map.put(c.commandType, c);
    }

    public static Command of(String name){
        return map.get(name);
    }


}
