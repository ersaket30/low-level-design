package model;

import java.util.ArrayList;
import java.util.List;

public class Library {

    String name;
    Address address;
    List<BookItem> books;

    private static Library library;

    public List<Rack> getRacks() {
        return racks;
    }

    List<Rack> racks;

    private Library(String name, Address address, int noOfRacks){
        this.name=name;
        this.address=address;
        this.racks=initializeRacks(noOfRacks);
        this.books=new ArrayList<>();
    }

    public static Library createInstance(String name, Address address, int noOfRacks){
        if(library==null){
            library = new Library(name,address,noOfRacks);
        }
        return library;

    }

    public  static Library getInstance(){
        return library;
    }

    private List<Rack> initializeRacks(int noOfRacks) {
        List<Rack> racks = new ArrayList<>(noOfRacks);
        for(int i=1;i<=noOfRacks;i++){
            racks.add(new Rack(i));
        }
        return racks;
    }


}
