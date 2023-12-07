package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PowerUp;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class DrawPowerUpTest {

    private DrawPowerUp drawPowerUp;
    private PowerUp powerUp;
    private LanternaGui gui;

    @BeforeEach
    public void setUp() {
        powerUp = mock(PowerUp.class);
        gui = mock(LanternaGui.class);
        drawPowerUp = new DrawPowerUp(powerUp);
    }

    @Test
    public void testDraw_HealthBoostActive() {
        when(powerUp.isActive()).thenReturn(1);
        when(powerUp.getPowerUpType()).thenReturn(PowerUp.PowerUpType.HealthBoost);

        drawPowerUp.draw(gui);

        verify(gui, times(1)).drawText(any(), any(), any());
    }

    @Test
    public void testDraw_ScoreBoostActive() {
        when(powerUp.isActive()).thenReturn(1);
        when(powerUp.getPowerUpType()).thenReturn(PowerUp.PowerUpType.ScoreBoost);

        drawPowerUp.draw(gui);

        verify(gui, times(1)).drawText(any(), any(), any());
    }

    @Test
    public void testDraw_HealthBoostInactive() {
        when(powerUp.isActive()).thenReturn(0);
        when(powerUp.getPowerUpType()).thenReturn(PowerUp.PowerUpType.HealthBoost);

        drawPowerUp.draw(gui);

        verify(gui).drawText(powerUp.getPosition(), "+", new TextColor.RGB(0, 255, 0));
    }

    @Test
    public void testDraw_ScoreBoostInactive() {
        when(powerUp.isActive()).thenReturn(0);
        when(powerUp.getPowerUpType()).thenReturn(PowerUp.PowerUpType.ScoreBoost);

        drawPowerUp.draw(gui);

        verify(gui).drawText(powerUp.getPosition(), "★", new TextColor.RGB(255, 255, 0));
    }
}