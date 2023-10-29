package com.Carlos.spaceinvanders.UI;

import com.Carlos.spaceinvanders.Entities.bulletModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class bulletDraw implements drawEntities{

    bulletModel bulletModel;
    bulletDraw(bulletModel bulletModel){
       this.bulletModel = bulletModel;
    }

    @Override
    public void draw(TextGraphics graphics){
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(bulletModel.getPosition().getX(), bulletModel.getPosition().getY()), "|");
    }
}
