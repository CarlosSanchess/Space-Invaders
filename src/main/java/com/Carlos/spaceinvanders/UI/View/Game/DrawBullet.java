package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Entities.Model.BulletModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DrawBullet implements DrawEntities {

    BulletModel bulletModel;
    public DrawBullet(BulletModel bulletModel){
       this.bulletModel = bulletModel;
    }

    @Override
    public void draw(TextGraphics graphics){
        TextColor textColor = new TextColor.RGB(255,105,97) ;
        graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor(textColor);
        graphics.putString(new TerminalPosition(bulletModel.getPosition().getX(), bulletModel.getPosition().getY()), "|");
    }
}
