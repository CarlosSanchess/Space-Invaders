package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.model.models.MonsterModel;


import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;
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