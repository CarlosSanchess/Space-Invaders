package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.GameOverMenuModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DrawGameOverMenuTest {

    @Mock
    private GameOverMenuModel mockModel;

    @Mock
    private LanternaGui mockGui;

    private DrawGameOverMenu drawGameOverMenu;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        drawGameOverMenu = new DrawGameOverMenu(mockModel);
    }

    @Test
    public void testDraw() {
        // Set up mock model
        when(mockModel.getText()).thenReturn("Game Over");
        when(mockModel.getEntryName(0)).thenReturn("EXIT TO MAIN MENU");
        when(mockModel.getEntryName(1)).thenReturn("RESTART GAME");
        when(mockModel.isSelected(0)).thenReturn(true);
        when(mockModel.isSelected(1)).thenReturn(false);

        // Call the draw method
        drawGameOverMenu.draw(mockGui);

        // Verify the expected GUI calls
        verify(mockGui).drawTitle("Game Over");
        verify(mockGui).drawTextSelected(new PositionModel(30, 17), "EXIT TO MAIN MENU", new TextColor.RGB(0, 255, 0));
        verify(mockGui).drawText(new PositionModel(34, 21), "RESTART GAME", new TextColor.RGB(255, 255, 255));
    }
}