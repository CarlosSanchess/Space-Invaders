package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.PowerUp;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DrawPlayerTest {

    @Mock
    private LanternaGui guiMock;

    private DrawPlayer drawPlayer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        PlayerModel playerModel = new PlayerModel(new PositionModel(10,10),3, PowerUp.PowerUpType.HealthBoost);
        drawPlayer = new DrawPlayer(playerModel);
    }

    @Test
    public void testDraw() {
        PlayerModel playerModel = drawPlayer.getModel();
        playerModel.setPosition(new PositionModel(10, 10));
        playerModel.setPowerUpType(PowerUp.PowerUpType.ScoreBoost);

        drawPlayer.draw(guiMock);

        verify(guiMock).getGraphics();
        verify(guiMock).drawText(new PositionModel(10, 8), "|", new TextColor.RGB(255, 255, 0), false);
        verify(guiMock).drawText(new PositionModel(8, 9), " /", new TextColor.RGB(255, 255, 0), false);
        verify(guiMock).drawText(new PositionModel(10, 9), " ", new TextColor.RGB(255, 255, 0), false);
        verify(guiMock).drawText(new PositionModel(11, 9), "\\ ", new TextColor.RGB(255, 255, 0), false);
        verify(guiMock).drawText(new PositionModel(8, 10), "<", new TextColor.RGB(255, 255, 0), false);
        verify(guiMock).drawText(new PositionModel(9, 10), "   ", new TextColor.RGB(255, 255, 0), false);
        verify(guiMock).drawText(new PositionModel(12, 10), ">", new TextColor.RGB(255, 255, 0), false);
        verify(guiMock).drawText(new PositionModel(9, 10), "___", new TextColor.RGB(255, 255, 0), false);
    }
}
