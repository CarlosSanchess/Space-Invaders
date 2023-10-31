package com.Carlos.spaceinvanders.UI;
import com.Carlos.spaceinvanders.Entities.playerModel;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class drawPlayer implements drawEntities{

    playerModel playerModel;
    public drawPlayer(playerModel player){
        this.playerModel = player;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor( new TextColor.RGB(0,255,0));
        graphics.putString(new TerminalPosition(playerModel.getPosition().getX(), playerModel.getPosition().getY()), "V");
    }
}

