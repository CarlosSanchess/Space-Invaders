package com.Carlos.spaceinvanders.UI;
import com.Carlos.spaceinvanders.Entities.PlayerModel;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DrawPlayer implements DrawEntities {

    PlayerModel playerModel;
    public DrawPlayer(PlayerModel player){
        this.playerModel = player;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor( new TextColor.RGB(0,255,0));
        graphics.putString(new TerminalPosition(playerModel.getPosition().getX(), playerModel.getPosition().getY()), "V");
    }
}

