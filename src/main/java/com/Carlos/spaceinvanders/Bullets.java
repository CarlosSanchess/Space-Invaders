package com.Carlos.spaceinvanders;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Bullets {

    private Position position;
    private int  speed;
    boolean active;
    Bullets(Position p, int speed){
        this.position = new Position(p.getX(), p.getY());
        this.speed = speed;
        this.active = true;
    }
    public int move(){
        position.setY(position.getY() - speed);
        return position.getY();
    }
    public void isActive(){
        if (position.getY() < 0){
            active = false;
        }
    }
    public void draw(TextGraphics graphics){
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "");

    }

    public Position getPosition(){
        return position;
    }
}