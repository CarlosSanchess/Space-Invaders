package com.Carlos.spaceinvanders.Entities.Model;

public class BulletModel extends Elements implements Model{
    private int  speed;
    private boolean active;
    private boolean direction;

    BulletModel(PositionModel position, int speed, boolean direction){
       super(position);
       this.speed = speed;
       this.direction = direction;
       active = true;
    }
}




/* public void move(){
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

    Acho que o bullet control vai ter de dar override a um move() que faz isto
*/