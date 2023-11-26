package com.Carlos.spaceinvanders.view.game;

import com.Carlos.spaceinvanders.model.models.MonsterModel;


import com.Carlos.spaceinvanders.gui.LanternaGui;
import com.Carlos.spaceinvanders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawMonster extends Viewer<MonsterModel> implements DrawElement {

    public DrawMonster(MonsterModel monsterModel){
        super(monsterModel);
    }
    @Override
    public void draw(LanternaGui GUI){
        MonsterModel monsterModel = super.getModel();
        GUI.drawText(monsterModel.getPosition(),"M",new TextColor.RGB(255,0,0));
    }
}
