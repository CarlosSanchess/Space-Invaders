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

    private PositionModel getRandomPosM(){
        long seed = System.currentTimeMillis();

        Random random = new Random(); //Implementar uma seed, para tornar realmente aleatorio o processo
        int randomNumber = random.nextInt(width - 1) + 1;
        return new PositionModel(randomNumber, 1);
    }
    public List<MonsterModel> addMonsters(int numMonstros){ // TODO Nao podem coincidir na posição
        for(int i = 0; i < numMonstros; i++){
            monsters.add(new MonsterModel(getRandomPosM(),3,1));
        }
        return monsters;
    }

}
