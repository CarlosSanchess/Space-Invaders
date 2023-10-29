package com.Carlos.spaceinvanders.Entities;

public class playerModel extends Elements{

    private int hitPoints; //Vida da Nave

    playerModel(positionModel position,int hitPoints){
        super(position);
        this.hitPoints = hitPoints;
    }
}