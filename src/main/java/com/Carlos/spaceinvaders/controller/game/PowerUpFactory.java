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
        this.Delay = 10000;
        this.lastCreation = 0;

    }


    public void createPowerUp(long Time, int arenaX){
        if(Time - lastCreation > Delay){
            PowerUp powerUp = new PowerUp(createRandomPosition(arenaX),1,1000,true,createRandomPower());
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
}
