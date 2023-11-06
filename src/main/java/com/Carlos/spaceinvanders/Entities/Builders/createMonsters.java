package com.Carlos.spaceinvanders.Entities.Builders;
import com.Carlos.spaceinvanders.Entities.monsterModel;
import com.Carlos.spaceinvanders.Entities.positionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Criar assim ou como BUilders create Walls
//TODO
//Opção de criar mais monstros, default 3
public class createMonsters {

    private int width;
    private List<monsterModel> monsters;

    public createMonsters(int width){
        monsters = new ArrayList<>();
        this.width = width;
    }

    private positionModel getRandomPosM(){
        long seed = System.currentTimeMillis();

        Random random = new Random(); //Implementar uma seed, para tornar realmente aleatorio o processo
        int randomNumber = random.nextInt(width - 1) + 1;
        return new positionModel(randomNumber, 1);
    }
    public List<monsterModel> addMonsters(int numMonstros){ // Nao podem coincidir na posição
        for(int i = 0; i < numMonstros; i++){
            monsters.add(new monsterModel(getRandomPosM(),3,1));
        }
        return monsters;
    }

}
