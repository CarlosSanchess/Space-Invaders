package com.Carlos.spaceinvaders.model.models;

import java.awt.*;

import java.awt.*;

public class PlayerModel extends Elements {

    private int hitPoints; //Not Used Yet

    public PlayerModel(PositionModel position, int hitPoints){
        super(position);
        this.hitPoints = hitPoints;
    }
    public BulletModel playerShoot(){
        return new BulletModel(new PositionModel(getPosition().getX(), getPosition().getY()),1,true); // Criar novo objeto para nao alterar o movimento da nave
    }

    public boolean canMove(PositionModel position) { // Permitir escolher tamanho da arena?
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return position.getX() >= 1 && position.getX()  < screenSize.width - 1;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}