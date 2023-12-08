package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PowerUpTest {

    @Test
    public void testGetPowerUpType() {
        PositionModel position = new PositionModel(0, 0);
        PowerUp powerUp = new PowerUp(position, 1, 1000, true, PowerUp.PowerUpType.HealthBoost);
        assertEquals(PowerUp.PowerUpType.HealthBoost, powerUp.getPowerUpType());
    }

    @Test
    public void testGetSpeed() {
        PositionModel position = new PositionModel(0, 0);
        PowerUp powerUp = new PowerUp(position, 2, 2000, true, PowerUp.PowerUpType.ScoreBoost);
        assertEquals(2, powerUp.getSpeed());
    }

    @Test
    public void testIncrementActive() {
        PositionModel position = new PositionModel(0, 0);
        PowerUp powerUp = new PowerUp(position, 3, 3000, true, PowerUp.PowerUpType.ScoreBoost);
        powerUp.incrementActive();
        assertEquals(1, powerUp.isActive());
    }

    @Test
    public void testMove() {
        PositionModel position = new PositionModel(0, 0);
        PowerUp powerUp = new PowerUp(position, 4, 4000, true, PowerUp.PowerUpType.HealthBoost);
        powerUp.move();
        assertEquals(4, powerUp.getPosition().getY());
    }
}