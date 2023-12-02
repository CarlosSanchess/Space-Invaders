package com.Carlos.spaceinvaders.model.builders;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TODO
//Opção de criar mais monstros, default 3
public class CreateMonsters {

    private int width;
    private List<MonsterModel> monsters;

    public CreateMonsters(int width){
        monsters = new ArrayList<>();
        this.width = width;
    }

    private PositionModel getRandomPosM(int y){
        Random random = new Random();
        int randomNumber = random.nextInt(width - 1) + 1;
        return new PositionModel(randomNumber, y);
    }
    public List<MonsterModel> addMonsters(int numMonstros){
        for(int i = 0; i < numMonstros; i++){
            int y = i * 2 + 1;
            monsters.add(new MonsterModel(getRandomPosM(y),3,1));
        }
        return monsters;
    }

}
