package com.Carlos.spaceinvanders.UI;
import com.Carlos.spaceinvanders.Entities.playerModel;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class playerDraw implements drawEntities{

    playerModel player;
    playerDraw(playerModel player){
        this.player = player;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(player.getPosition().getX(), player.getPosition().getY()), "V");
    }
}

