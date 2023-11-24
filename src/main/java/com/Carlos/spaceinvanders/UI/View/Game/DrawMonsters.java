package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Entities.Model.MonsterModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
import com.googlecode.lanterna.TextColor;

import java.util.List;

public class DrawMonsters extends Viewer<List<MonsterModel>> {

    public DrawMonsters(List<MonsterModel> monsters){
        super(monsters);
    }

    @Override
    public void draw(LanternaGui GUI){
        for (MonsterModel monsterModel : super.getModel()) {
            DrawMonster drawMonster = new DrawMonster(monsterModel);
            drawMonster.draw(GUI);
        }
    }
}
