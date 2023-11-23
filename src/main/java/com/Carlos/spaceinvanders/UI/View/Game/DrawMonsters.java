package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Entities.Model.MonsterModel;
import com.Carlos.spaceinvanders.UI.View.Game.DrawEntities;
import com.Carlos.spaceinvanders.UI.View.Game.DrawMonster;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class DrawMonsters implements DrawEntities {

    List<MonsterModel> monsters;
    DrawMonster monsterDraw;

    public DrawMonsters(List<MonsterModel> monsters){
        this.monsters = monsters;
    }

    @Override
    public void draw(TextGraphics graphics){
        for (MonsterModel monster : monsters) {
            monsterDraw = new DrawMonster(monster);
            monsterDraw.draw(graphics);

        }
    }
}