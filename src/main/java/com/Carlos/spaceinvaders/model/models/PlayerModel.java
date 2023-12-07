package com.Carlos.spaceinvaders.model.models;

import java.awt.*;
import  com.Carlos.spaceinvaders.model.models.PowerUp.PowerUpType;



public class PlayerModel extends Elements {

    private int hitPoints; //Not Used Yet
    private long delayShooting;
    private PowerUpType powerUpType;

    public PlayerModel(PositionModel position, int hitPoints, PowerUpType powerUpType){
        super(position);
        this.hitPoints = hitPoints;
        this.delayShooting = 500;
        this.powerUpType = null;
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
    public void setDelayShooting(long delayShooting) {
        this.delayShooting = delayShooting;
    }
    public long getDelayShooting() {
        return delayShooting;
    }
    public PowerUpType getPowerUpType() {
        return powerUpType;
    }
    public void setPowerUpType(PowerUpType powerUpType) {
        this.powerUpType = powerUpType;
    }
}