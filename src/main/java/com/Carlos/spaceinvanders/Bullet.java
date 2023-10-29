package com.Carlos.spaceinvanders;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Bullet {

    private Position position;
    private int  speed;
    private boolean active;
    private boolean direction;
    Bullet(Position p, int speed,boolean direction){
        this.position = new Position(p.getX(), p.getY());
        this.speed = speed;
        this.active = true;
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
    public void draw(TextGraphics graphics){
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "|");

    }

    public Position getPosition(){
        return position;
    }
}