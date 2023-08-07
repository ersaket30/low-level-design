package model;

import java.util.UUID;

public class Player {
    private final String id;
    private final String name;
    private int position;

    public Player(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        position = 0;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
}
