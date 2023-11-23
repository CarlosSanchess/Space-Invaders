package com.Carlos.spaceinvanders.UI.View;

import com.Carlos.spaceinvanders.Entities.Model.MonsterModel;


import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DrawMonster implements DrawEntities {
    //arena fixa?
    //1 ao 79

    private TextColor textColor = new TextColor.RGB(255,105,97);
    private final MonsterModel monsterModel;
    public DrawMonster(MonsterModel monsterModel){
        this.monsterModel = monsterModel;
    }

    @Override
    public void draw(TextGraphics graphics){
        graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor(textColor);
        graphics.putString(new TerminalPosition(monsterModel.getPosition().getX(),monsterModel.getPosition().getY()), "x");
    }


}
