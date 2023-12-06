package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private PlayerModel playerModel;

    @BeforeEach
    public void setUp() {
        PositionModel position = new PositionModel(0, 0);
        playerModel = new PlayerModel(position, 3, null);
    }

    @Test
    public void testPlayerShoot() {
        BulletModel bulletModel = playerModel.playerShoot();
        assertNotNull(bulletModel);
        assertEquals(0, bulletModel.getPosition().getX());
        assertEquals(0, bulletModel.getPosition().getY());
        assertEquals(1, bulletModel.getSpeed());
        assertTrue(bulletModel.isActive());
    }

    @Test
    public void testCanMove() {
        PositionModel position1 = new PositionModel(1, 0);
        assertTrue(playerModel.canMove(position1));

        PositionModel position2 = new PositionModel(0, 0);
        assertFalse(playerModel.canMove(position2));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        PositionModel position3 = new PositionModel(screenSize.width - 1, 0);
        assertFalse(playerModel.canMove(position3));

        PositionModel position4 = new PositionModel(screenSize.width, 0);
        assertFalse(playerModel.canMove(position4));
    }

    @Test
    public void testGetHitPoints() {
        assertEquals(3, playerModel.getHitPoints());
    }

    @Test
    public void testIncrementHitPoints() {
        playerModel.incrementHitPoints();
        assertEquals(4, playerModel.getHitPoints());
    }

    @Test
    public void testDecrementHitPoints() {
        playerModel.decrementHitPoints();
        assertEquals(2, playerModel.getHitPoints());
    }

    @Test
    public void testSetDelayShooting() {
        playerModel.setDelayShooting(1000);
        assertEquals(1000, playerModel.getDelayShooting());
    }

    @Test
    public void testGetPowerUpType() {
        assertNull(playerModel.getPowerUpType());
    }

    @Test
    public void testSetPowerUpType() {
        PowerUp.PowerUpType powerUpType = PowerUp.PowerUpType.HealthBoost;
        playerModel.setPowerUpType(powerUpType);
        assertEquals(powerUpType, playerModel.getPowerUpType());
    }
}
