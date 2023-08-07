package model;

import java.util.Random;

public class Dice {

    int maxNumber;

    public Dice(int size){
       this.maxNumber=size;
    }

    public int roll(){
        Random rand = new Random();
        return 1 + rand.nextInt(maxNumber);
    }
}
