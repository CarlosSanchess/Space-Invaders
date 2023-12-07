package com.Carlos.spaceinvaders.model.models;

public class BulletModel extends Elements {
    private final int  speed;
    private boolean active = true;
    private final boolean direction;

    public BulletModel(PositionModel position, int speed, boolean direction){
       super(position);
       this.speed = speed;
       this.direction = direction;
    }

    public boolean getActive(){
        return active;
    }
    public void processActive(int arenaH){
        if (position.getY() < 0 && direction) {
            active = false;
        }
        if(position.getY() > arenaH - 1 && !direction){
            active = false;
        }
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getDirection(){
        return direction;
    }
    public int getSpeed() {
        return speed;
    }
}