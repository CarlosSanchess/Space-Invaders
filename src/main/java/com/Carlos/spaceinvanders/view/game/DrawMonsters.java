package com.Carlos.spaceinvanders.view.game;


import com.Carlos.spaceinvanders.model.models.MonsterModel;
import com.Carlos.spaceinvanders.gui.LanternaGui;
import com.Carlos.spaceinvanders.view.Viewer;

import java.util.List;

public class DrawMonsters extends Viewer<List<MonsterModel>> implements DrawElement{
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
