package com.Carlos.spaceinvaders.model.models;

import java.awt.*;

import java.awt.*;

public class PlayerModel extends Elements {

    private int hitPoints; //Not Used Yet
    private int delayShooting;

    public PlayerModel(PositionModel position, int hitPoints){
        super(position);
        this.hitPoints = hitPoints;
        this.delayShooting = 100;
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

    public void incrementHitPoints(){
        this.hitPoints++;
    }
    public void decrementHitPoints(){
        this.hitPoints--;
    }
    public void setDelayShooting(int delayShooting) {
        this.delayShooting = delayShooting;
    }
    public int getDelayShooting() {
        return delayShooting;
    }
}