package model;


import java.util.Map;

public class Board {

    private int breadth;
    private int height;
    private int size;
    private Map<Integer,Snake> snakes;
    private Map<Integer,Ladder> ladders;

    public Board(int height, int breadth, Map<Integer,Snake> snakes, Map<Integer,Ladder> ladders){
        this.height= height;
        this.breadth = breadth;
        this.snakes= snakes;
        this.ladders=ladders;
        this.size=height*breadth;
    }

    public int getSize(){
        return size;
    }

    public Map<Integer, Snake> getSnakes() {

        return snakes;
    }

    public Map<Integer, Ladder> getLadders() {

        return ladders;
    }
}
