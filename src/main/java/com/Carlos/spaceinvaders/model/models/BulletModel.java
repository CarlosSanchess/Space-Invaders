package com.Carlos.spaceinvaders.model.models;

public class BulletModel extends Elements {
    private int  speed;
    private boolean active;
    private boolean direction;

    public BulletModel(PositionModel position, int speed, boolean direction){
       super(position);
       this.speed = speed;
       this.direction = direction;
       active = true;
    }

    public void move(){

        if(direction)
            position.setY(position.getY() - speed);
        else
            position.setY(position.getY() + speed);
        active = isActive();
    }
    public boolean isActive(){
        if (position.getY() < 0){
            active = false;
        }
        return active;
    }
}