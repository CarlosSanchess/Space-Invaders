package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Entities.Model.MonsterModel;


import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawMonster extends Viewer<MonsterModel> implements DrawElement {

    public DrawMonster(MonsterModel monsterModel){
        super(monsterModel);
    }
    @Override
    public void draw(LanternaGui GUI){
        MonsterModel monsterModel = super.getModel();
        GUI.drawText(monsterModel.getPosition(),"M",new TextColor.RGB(255,0,0),Boolean.FALSE);
    }
}
