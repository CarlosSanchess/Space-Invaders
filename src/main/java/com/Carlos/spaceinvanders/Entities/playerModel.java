package com.Carlos.spaceinvanders.Entities;

public class playerModel extends Elements{

    private int hitPoints; //Vida da Nave

    playerModel(positionModel position,int hitPoints){
        super(position);
        this.hitPoints = hitPoints;
    }

    public boolean canMove(positionModel position) { // Premitir escolher tamanho da arena?
        return position.getX() >= 1 && position.getX()  < 80 - 1;
    }

    public void moveLeft(positionModel position){
        if(canMove(new positionModel(position.getX() - 1,position.getY()))){
            position.setX(position.getX() - 1);
        }
    }
    public void moveRight(positionModel position){
        if(canMove(new positionModel(position.getX() + 1,position.getY()))){
            position.setX(position.getX() + 1);
        }
    }
    public bulletModel playerShoot(){
        return new bulletModel(position,1,true);
    }
}