package com.Carlos.spaceinvanders.UI;
import com.Carlos.spaceinvanders.Entities.wallModel;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class drawWall implements drawEntities{

    wallModel wall;
    public drawWall(wallModel wall){
        this.wall = wall;
    }

    @Override
    public void draw(TextGraphics graphics) {
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(wall.getPosition().getX(), wall.getPosition().getY()), "*");
        }
    }

