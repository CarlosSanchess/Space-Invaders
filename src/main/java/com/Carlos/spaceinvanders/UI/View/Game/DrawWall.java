package com.Carlos.spaceinvanders.UI.View.Game;
import com.Carlos.spaceinvanders.Entities.Model.WallModel;

import com.Carlos.spaceinvanders.UI.View.Game.DrawEntities;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DrawWall implements DrawEntities {

    WallModel wall;
    public DrawWall(WallModel wall){
        this.wall = wall;
    }

    @Override
    public void draw(TextGraphics graphics) {
            graphics.enableModifiers(SGR.BOLD);
            graphics.setForegroundColor(new TextColor.RGB(255,255,255));
            graphics.putString(new TerminalPosition(wall.getPosition().getX(), wall.getPosition().getY()), "*");
        }
    }

