package com.Carlos.spaceinvanders.Entities;


import java.util.Random;

public class monsterModel extends Elements{
    //Se quiser mudar o size da arena, fazer com que a posição nao seja definida aqui.


    // Criar uma posição random na primeira linha de arena
    //Impedir que haja duplicação de monsters
    private int hitPoints;
    boolean direction = false;
    private final int speed;
    public monsterModel(positionModel position,int hitPoints, int speed){
        super(position);
        this.hitPoints = hitPoints;
        this.speed = speed;
    }
    public void move(){
        if(direction)
            position.setY(position.getY() - speed);
        else
            position.setY(position.getY() + speed);
    }
}
