package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Entities.Model.MonsterModel;


import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Game.DrawEntities;
import com.Carlos.spaceinvanders.UI.View.Viewer;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DrawMonster extends Viewer<MonsterModel> {

    public DrawMonster(MonsterModel monsterModel){
        super(monsterModel);
    }
    @Override
    public void draw(LanternaGui GUI){
        MonsterModel monsterModel = super.getModel();
        GUI.drawText(monsterModel.getPosition(),"x",new TextColor.RGB(255,105,97));
    }
}
