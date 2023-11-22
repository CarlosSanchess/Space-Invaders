package com.Carlos.spaceinvanders.Entities.Builders;
import com.Carlos.spaceinvanders.Entities.MonsterModel;
import com.Carlos.spaceinvanders.Entities.PositionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Criar assim ou como BUilders create Walls
//TODO
//Opção de criar mais monstros, default 3
public class createMonsters {

    private int width;
    private List<MonsterModel> monsters;

    public createMonsters(int width){
        monsters = new ArrayList<>();
        this.width = width;
    }

    private PositionModel getRandomPosM(){
        long seed = System.currentTimeMillis();

        Random random = new Random(); //Implementar uma seed, para tornar realmente aleatorio o processo
        int randomNumber = random.nextInt(width - 1) + 1;
        return new PositionModel(randomNumber, 1);
    }
    public List<MonsterModel> addMonsters(int numMonstros){ // Nao podem coincidir na posição
        for(int i = 0; i < numMonstros; i++){
            monsters.add(new MonsterModel(getRandomPosM(),3,1));
        }
        return monsters;
    }

}