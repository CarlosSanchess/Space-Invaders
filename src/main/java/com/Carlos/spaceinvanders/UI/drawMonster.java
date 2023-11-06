package com.Carlos.spaceinvanders.UI;

import com.Carlos.spaceinvanders.Entities.monsterModel;


import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class drawMonster implements drawEntities{
    //arena fixa?
    //1 ao 79
    ;
    private final monsterModel monsterModel;
    public drawMonster(monsterModel monsterModel){
        this.monsterModel = monsterModel;
    }

    @Override
    public void draw(TextGraphics graphics){
        TextColor textColor = new TextColor.RGB(255,105,97) ;
        graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor(textColor);
        graphics.putString(new TerminalPosition(monsterModel.getPosition().getX(),monsterModel.getPosition().getY()), "x");
    }


}
