package com.Carlos.spaceinvanders.Entities;

public class bulletModel extends Elements{
    private int  speed;
    private boolean active;
    private boolean direction;

    bulletModel(positionModel position, int speed,boolean direction){
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
    }
    public boolean isActive(){
        if (position.getY() <= 0){
            active = false;
            return active;
        }
        return active;
    }

}
