package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterFactory {

        private final List<MonsterModel> activeMonsters;
        long lastCreation;
        long Delay;
        private int numMonstros;
        MonsterFactory(List<MonsterModel> activeMonsters){
            this.activeMonsters = activeMonsters;
            this.Delay = 3000;
            this.lastCreation = 0;
            this.numMonstros = 1;

        }


    public List<MonsterModel> createMonster(long Time, int arenaX){
        if(Time - lastCreation > Delay){
            List<MonsterModel> newMonsters = new ArrayList<>();
            for(int i = 0; i < numMonstros; i++){
                MonsterModel monsterModel = new MonsterModel(createRandomPosition(arenaX),1,1);
                activeMonsters.add(monsterModel);
                newMonsters.add(monsterModel);
            }
            this.lastCreation = Time;
            return newMonsters;
        }
        return null;
    }

        private PositionModel createRandomPosition(int arenaX){
            Random random = new Random();
            int x = random.nextInt(arenaX - 2) + 1; // Generate a random number between 1 and arenaX - 1
            return new PositionModel(x, 1); // TODO
        }

        public void setDelay(long delay) {
            Delay = delay;
        }

        public long getDelay() {
            return Delay;
        }
    }

