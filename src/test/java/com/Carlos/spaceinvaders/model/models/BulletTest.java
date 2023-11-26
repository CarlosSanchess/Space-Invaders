package com.Carlos.spaceinvaders.model.models;


import com.Carlos.spaceinvanders.model.models.BulletModel;
import com.Carlos.spaceinvanders.model.models.PositionModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class BulletTest {
    private BulletModel bullet;

    @BeforeEach
    public void setUp() {
        PositionModel position = new PositionModel(0, 0);
        int speed = 5;
        boolean direction = true;
        bullet = new BulletModel(position, speed, direction);
    }

    @Test
    public void testMove() {
        bullet.move();
        assertEquals(-5, bullet.getPosition().getY());
    }

    @Test
    public void testIsActive() {
        assertTrue(bullet.isActive());

        bullet.getPosition().setY(-10);
        assertFalse(bullet.isActive());
    }
}
