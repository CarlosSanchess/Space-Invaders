package com.Carlos.spaceinvaders.model.models;

public class PowerUp extends Elements {

    public enum PowerUpType{
        HealthBoost,
        ScoreBoost
    }
    private long upTime;
    PositionModel position;
    private final int speed;
    private boolean active;
    private PowerUpType powerUpType;
    public PowerUp(PositionModel position, int speed, long upTime, boolean active,PowerUpType powerUpType){
        super(position);
        this.speed = speed;
        this.upTime = upTime;
        this.active = false;
        this.powerUpType = powerUpType;
    }

    public PowerUpType getPowerUpType() {
        return powerUpType;
    }
    public int getSpeed(){
        return speed;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
    public void move(){
        getPosition().setY(getPosition().getY() + speed);
    }
}
