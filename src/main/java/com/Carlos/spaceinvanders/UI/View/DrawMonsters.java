package com.Carlos.spaceinvanders.UI;

import com.Carlos.spaceinvanders.Entities.MonsterModel;
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
