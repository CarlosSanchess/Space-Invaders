package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BulletTest {

    private BulletModel bulletModel;

    @BeforeEach
    public void setUp() {
        PositionModel position = new PositionModel(0, 0);
        int speed = 10;
        boolean direction = true;
        bulletModel = new BulletModel(position, speed, direction);
    }

    @Test
    public void testIsActiveInitially() {
        assertTrue(bulletModel.isActive());
    }

    @Test
    public void testIsActive() {
        bulletModel.getPosition().setY(-10);
        assertFalse(bulletModel.isActive());

        bulletModel.getPosition().setY(0);
        assertTrue(bulletModel.isActive());

        bulletModel.getPosition().setY(10);
        assertTrue(bulletModel.isActive());
    }

    @Test
    public void testNotActiveWhenOffScreen() {
        bulletModel.getPosition().setY(-110);
        assertFalse(bulletModel.isActive());
    }

    @Test
    public void testSetActive() {
        bulletModel.setActive(false);
        assertFalse(bulletModel.isActive());

        bulletModel.setActive(true);
        assertTrue(bulletModel.isActive());
    }

    @Test
    public void testGetDirection() {
        assertTrue(bulletModel.getDirection());
    }

    @Test
    public void testGetSpeed() {
        assertEquals(10, bulletModel.getSpeed());
    }
}