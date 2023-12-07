package com.Carlos.spaceinvaders.gui;

import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TerminalSize;
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
        lanternaGui = new LanternaGui(80, 20);
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

    @Test
    public void testScreenClear() {
        TerminalPosition position = new TerminalPosition(0, 0);

        lanternaGui.screenClear();

        verify(screenMock).clear();
        verify(graphicsMock).setBackgroundColor(TextColor.Factory.fromString("#010327"));
        verify(graphicsMock).fillRectangle(eq(position), isNull(), eq(' '));
    }

    @Test
    public void testScreenRefresh() throws IOException {
        lanternaGui.screenRefresh();
        verify(screenMock).refresh();
    }

    @Test
    public void testDrawTextSelected() {
        PositionModel position = new PositionModel(10, 10);
        String entryName = "Test Entry";
        TextColor.RGB rgbColor = new TextColor.RGB(0, 255, 0);

        lanternaGui.drawTextSelected(position, entryName, rgbColor);

        verify(graphicsMock, times(4)).setForegroundColor(new TextColor.RGB(0, 255, 0));
        verify(graphicsMock).setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        verify(graphicsMock).putString(9, 9, "+");
        verify(graphicsMock, times((entryName.length() + 2) - 2)).putString(anyInt(), anyInt(), eq("-"));
        verify(graphicsMock).putString(9 + entryName.length(), 9, "+");
        verify(graphicsMock).setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        verify(graphicsMock).putString(9, 10, "|");
        verify(graphicsMock).setForegroundColor(new TextColor.RGB(0, 255, 0));
        verify(graphicsMock).putString(10, 10, entryName);
        verify(graphicsMock).setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        verify(graphicsMock).putString(9 + entryName.length(), 10, "|");
        verify(graphicsMock).putString(9, 11, "+");
        verify(graphicsMock, times((entryName.length() + 2) - 2)).putString(anyInt(), eq(11), eq("-"));
        verify(graphicsMock).putString(9 + entryName.length(), 11, "+");
    }

    @Test
    public void testGetGraphics() {
        TextGraphics graphics = lanternaGui.getGraphics();

        assertEquals(graphicsMock, graphics);
    }
}