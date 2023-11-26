package com.Carlos.spaceinvaders.model.models;

import java.awt.*;

public class PlayerModel extends Elements {

    private int hitPoints; //Vida da Nave

    public PlayerModel(PositionModel position, int hitPoints){
        super(position);
        this.hitPoints = hitPoints;
    }
    public BulletModel playerShoot(){
        return new BulletModel(new PositionModel(getPosition().getX(), getPosition().getY()),1,true); // Criar novo objeto para nao alterar o movimento da nave
    }

    public boolean canMove(PositionModel position) { // Premitir escolher tamanho da arena?
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return position.getX() >= 1 && position.getX()  < screenSize.width - 1;
    }

    public void moveLeft(PositionModel position){
        if(canMove(new PositionModel(position.getX() - 1,position.getY()))){
            position.setX(position.getX() - 1);
        }
    }
    public void moveRight(PositionModel position){
        if(canMove(new PositionModel(position.getX() + 1,position.getY()))){
            position.setX(position.getX() + 1);
        }
    }
}