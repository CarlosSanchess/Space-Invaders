package com.Carlos.spaceinvaders.model.models;

public class PowerUp extends Elements {

    public enum PowerUpType{
        HealthBoost,
        ScoreBoost,
        FireRateBoost
    }
    private long upTime;
    PositionModel position;
    private final int speed;
    private int active; // 0 por atingir 1 em exec 2 para ser elem
    private PowerUpType powerUpType;
    public PowerUp(PositionModel position, int speed, long upTime, boolean active,PowerUpType powerUpType){
        super(position);
        this.speed = speed;
        this.upTime = upTime;
        this.active = 0;
        this.powerUpType = powerUpType;
    }

    public PowerUpType getPowerUpType() {
        return powerUpType;
    }
    public int getSpeed(){
        return speed;
    }

    public void incrementActive() {
        this.active = (this.active + 1) % 3;
    }

    public int isActive() {
        return active;
    }
    public void move(){
        getPosition().setY(getPosition().getY() + speed);
    }
}
