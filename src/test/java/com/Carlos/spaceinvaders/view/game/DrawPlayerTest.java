package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class DrawPlayerTest {
    private DrawPlayer drawPlayer;
    private PlayerModel playerModel;
    private LanternaGui gui;

    @BeforeEach
    public void setUp() {
        playerModel = Mockito.mock(PlayerModel.class);
        gui = Mockito.mock(LanternaGui.class);
        drawPlayer = new DrawPlayer(playerModel);
    }

    @Test
    public void testDraw() {
        drawPlayer.draw(gui);
        verify(gui).drawText(playerModel.getPosition(), "P", new TextColor.RGB(0, 255, 0));
    }
}
