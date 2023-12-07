package com.Carlos.spaceinvaders.gui;

import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.menu.DrawMenu;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LanternaGuiTest {

    @Mock
    private TextGraphics graphicsMock;

    @Mock
    private Screen screenMock;

    private LanternaGui lanternaGui;

    @BeforeEach
    public void setUp() throws IOException, FontFormatException {
        MockitoAnnotations.openMocks(this);
        lanternaGui = new LanternaGui(80,20);
        lanternaGui.setScreen(screenMock);
        lanternaGui.setGraphics(graphicsMock);
    }

    @Test
    public void testDrawText() {
        PositionModel position = new PositionModel(0, 0);
        String string = "ALIEN";

        lanternaGui.drawText(position, string, null);

        verify(graphicsMock).putString(position.getX(), position.getY(), string);
    }

    @Test
    public void testDrawTitle() {
        String title = "Space Invaders";

        lanternaGui.drawTitle(title);

        verify(graphicsMock).putString(anyInt(), anyInt(), eq(title));
    }

    @Test
    public void testDrawEntries() {
        MenuModel menuModel = new MenuModel();

        lanternaGui.drawEntries(menuModel);

        verify(graphicsMock, times(menuModel.getEntries().size())).putString(anyInt(), anyInt(), anyString());
    }

    @Test
    public void testGetStartPoint() {
        String string1 = "New Game";
        String string2 = "Exit";

        int startPoint1 = lanternaGui.getStartPoint(string1, 80);
        int startPoint2 = lanternaGui.getStartPoint(string2, 80);

        assertEquals(36, startPoint1);
        assertEquals(38, startPoint2);
    }
}