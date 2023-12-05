package com.Carlos.spaceinvaders.model.models.PowerUp;

import com.Carlos.spaceinvaders.model.models.Elements;
import com.Carlos.spaceinvaders.model.models.PositionModel;

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
        this.active = true;
        this.powerUpType = powerUpType;
    }

    public PowerUpType getPowerUpType() {
        return powerUpType;
    }
    public int getSpeed(){
        return speed;
    }
}
