package model;


public class Slot {

    VehicleType type;
    int id;
    boolean isAvailable;
    int floorId;

    public Slot(int id,int floorId, VehicleType type){
        this.id= id;
        this.type=type;
        this.isAvailable=true;
        this.floorId=floorId;
    }

   public boolean isAvailable(){
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable){
         this.isAvailable = isAvailable;
    }

    public int getFloorId(){
        return floorId;
    }

    public int getId(){
        return id;
    }

    public VehicleType getType(){
        return type;
    }



}
