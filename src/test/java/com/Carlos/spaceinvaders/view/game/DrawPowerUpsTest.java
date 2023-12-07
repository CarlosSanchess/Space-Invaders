package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.PowerUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.googlecode.lanterna.TextColor;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DrawPowerUpsTest {

    @Mock
    private LanternaGui mockGui;

    private DrawPowerUps drawPowerUps;
    private List<PowerUp> powerUps;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        powerUps = new ArrayList<>();
        drawPowerUps = new DrawPowerUps(powerUps);
    }

    @Test
    public void testDraw() {
        PowerUp powerUp1 = new PowerUp(new PositionModel(1, 1), 10,10,false, PowerUp.PowerUpType.ScoreBoost);
        PowerUp powerUp2 = new PowerUp(new PositionModel(2, 2), 20, 10,true, PowerUp.PowerUpType.HealthBoost);

        powerUps.add(powerUp1);
        powerUps.add(powerUp2);

        drawPowerUps.draw(mockGui);

        verify(mockGui, times(2)).drawText(any(PositionModel.class), any(String.class), any(TextColor.RGB.class));
    }
}