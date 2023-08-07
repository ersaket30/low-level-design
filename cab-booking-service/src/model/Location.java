package model;

public class Location {

    Double x;
    Double y;

    public Location(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    Double distance(Location to) {

        return Math.sqrt(Math.pow(this.x - to.x, 2) - Math.pow(this.y - to.y, 2));

    }

}
