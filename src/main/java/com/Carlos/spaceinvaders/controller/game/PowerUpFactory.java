package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.PowerUpModel;

import java.util.List;
import java.util.Random;

public class PowerUpFactory {

    private int numPowerUp;
    private List<PowerUpModel> activePowerUps;
    long lastCreation;
    long Delay;
    PowerUpFactory(List<PowerUpModel> activePowerUps){
        this.activePowerUps = activePowerUps;
        this.Delay = 17500;
        this.lastCreation = 0;

    }


    public void createPowerUp(long Time, int arenaX){
        if(Time - lastCreation > Delay){
            PowerUpModel powerUp = new PowerUpModel(createRandomPosition(arenaX),1,100,createRandomPower());
            activePowerUps.add(powerUp);

            this.lastCreation = Time;
        }
    }

    private PowerUpModel.PowerUpType createRandomPower() {
        Random random = new Random();
        float chance = random.nextFloat();
        if (chance < 1.0/3.0) {
            return PowerUpModel.PowerUpType.HealthBoost;
        } else if (chance < 2.0/3.0) {
            return PowerUpModel.PowerUpType.ScoreBoost;
        } else {
            return PowerUpModel.PowerUpType.FireRateBoost;
        }
    }
    private PositionModel createRandomPosition(int arenaX){
        Random random = new Random();
        int x = random.nextInt(arenaX - 2) + 1; // Generate a random number between 1 and arenaX - 1
        return new PositionModel(x, 1); // TODO
    }

    public void setDelay(long delay) {
        Delay = delay;
    }

    public long getDelay() {
        return Delay;
    }

    public long getLastCreation() {
        return lastCreation;
    }
}