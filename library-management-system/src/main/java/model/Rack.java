package model;


public class Rack {

    Integer rackNo;

    public boolean isFree() {
        return isFree;
    }

    boolean isFree;

    Rack(Integer rackNo){
        this.rackNo=rackNo;
        this.isFree=true;
    }
    public void deAllocate(){
        this.isFree=true;
    }

    public Integer getRackNo() {
        return rackNo;
    }

    public void allocateRack() {
        this.isFree=false;
    }
}
