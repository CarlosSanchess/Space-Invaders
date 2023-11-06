package com.Carlos.spaceinvanders.UI;

import com.Carlos.spaceinvanders.Entities.monsterModel;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class drawMonsters implements drawEntities{

    List<monsterModel> monsters;
    drawMonster monsterDraw;

    public drawMonsters(List<monsterModel> monsters){
        this.monsters = monsters;
    }

    @Override
    public void draw(TextGraphics graphics){
        for (monsterModel monster : monsters) {
            monsterDraw = new drawMonster(monster);
            monsterDraw.draw(graphics);

        }
    }
}
