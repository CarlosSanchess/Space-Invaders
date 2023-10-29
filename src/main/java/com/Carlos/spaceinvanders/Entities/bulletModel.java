package com.Carlos.spaceinvanders.Entities;

import com.Carlos.spaceinvanders.Position;

public class bulletModel extends Elements{
    private int  speed;
    private boolean active;
    private boolean direction;

    bulletModel(positionModel position, int speed,boolean direction){
       super(position);
       this.speed = speed;
       this.direction = direction;

    }
    public int move(){
        if(direction == true)
            position.setY(position.getY() + speed);
        else
            position.setY(position.getY() - speed);
        return position.getY();
    }
    public boolean isActive(){
        if (position.getY() < 0){
            active = false;
            return active;
        }
        return active;
    }
}
