package com.Carlos.spaceinvaders.model.models;

public class MonsterModel extends Elements {

    private int hitPoints; // Not Used Yet
    boolean direction = false;
    private final int speed;

    public MonsterModel(PositionModel position, int hitPoints, int speed) {
        super(position);
        this.hitPoints = hitPoints;
        this.speed = speed;
    }

    public void move() {
        if (direction)
            position.setY(position.getY() - speed);
        else
            position.setY(position.getY() + speed);
    }
    public void setDirection(boolean b) {
        this.direction = b;
    }
}