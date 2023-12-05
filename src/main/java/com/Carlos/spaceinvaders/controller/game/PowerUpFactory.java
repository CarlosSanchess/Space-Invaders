package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.PowerUp.PowerUp;

import java.util.List;
import java.util.Random;

public class PowerUpFactory {

    private int numPowerUp;
    private List<PowerUp> activePowerUps;
    long lastCreation;
    long Delay;
    PowerUpFactory(List<PowerUp> activePowerUps){
        this.activePowerUps = activePowerUps;

    }


    public void createPowerUp(long Time){
        if(Time - lastCreation > 1000){
            PowerUp powerUp = new PowerUp(new PositionModel(40,3),1,1000,true,createRandomPower());
            activePowerUps.add(powerUp);

            this.lastCreation = Time;
        }
    }

    private PowerUp.PowerUpType createRandomPower() {
        Random random = new Random();
        if (random.nextFloat() < 0.5) {
            return PowerUp.PowerUpType.HealthBoost;
        } else {
            return PowerUp.PowerUpType.ScoreBoost;
        }
    }
}
