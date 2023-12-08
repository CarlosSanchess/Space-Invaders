package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.PowerUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PowerUpControllerTest {

    private PowerUpController powerUpController;
    private List<PowerUp> powerUps;

    @BeforeEach
    public void setUp() {
        powerUps = new ArrayList<>();
        powerUpController = new PowerUpController(powerUps);
    }

    @Test
    public void testMove() {
        PowerUp powerUp1 = mock(PowerUp.class);
        PowerUp powerUp2 = mock(PowerUp.class);
        powerUps.add(powerUp1);
        powerUps.add(powerUp2);

        powerUpController.move();

        verify(powerUp1, times(1)).move();
        verify(powerUp2, times(1)).move();
    }
    @Test
    public void testSetLastMove() {
        int move = 1000;

        powerUpController.setLastMove(move);

        assertEquals(move, powerUpController.getLastMove());
    }
}