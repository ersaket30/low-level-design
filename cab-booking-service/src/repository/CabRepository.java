package repository;

import model.Cab;

import java.util.HashMap;
import java.util.Map;

public class CabRepository {

    Map<String, Cab> cabs = new HashMap<>();

    public String addCab(Cab cab){
        cabs.put(cab.getId(),cab);
        return "Cab Added";
    }

    public Cab getCabById(String id){
        return cabs.get(id);
    }
}
