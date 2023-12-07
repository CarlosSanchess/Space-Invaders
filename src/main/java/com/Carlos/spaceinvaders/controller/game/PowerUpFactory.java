package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.PowerUp;

import java.util.List;
import java.util.Random;

public class PowerUpFactory {

    private int numPowerUp;
    private static List<PowerUp> activePowerUps;
    static long lastCreation;
    static long Delay;
    PowerUpFactory(List<PowerUp> activePowerUps){
        PowerUpFactory.activePowerUps = activePowerUps;
        Delay = 10000;
        lastCreation = 0;

    }


    public static void createPowerUp(long Time, int arenaX){
        if(Time - lastCreation > Delay){
            PowerUp powerUp = new PowerUp(createRandomPosition(arenaX),1,1000,true,createRandomPower());
            activePowerUps.add(powerUp);

            lastCreation = Time;
        }
    }

    private static PowerUp.PowerUpType createRandomPower() {
        Random random = new Random();
        if (random.nextFloat() < 0.5) {
            return PowerUp.PowerUpType.HealthBoost;
        } else {
            return PowerUp.PowerUpType.ScoreBoost;
        }
    }
    private static PositionModel createRandomPosition(int arenaX){
        Random random = new Random();
        int x = random.nextInt(arenaX - 2) + 1;
        return new PositionModel(x, 1);
    }

    public static PowerUp createPowerUp(PowerUp.PowerUpType powerUpType, PositionModel positionModel) {
        return new PowerUp(positionModel,5,10,true, powerUpType);
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
