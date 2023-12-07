package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class DrawMenuTest {

    private DrawMenu drawMenu;
    private MenuModel menuModel;
    private LanternaGui gui;

    @BeforeEach
    public void setUp() {
        menuModel = Mockito.mock(MenuModel.class);
        gui = Mockito.mock(LanternaGui.class);
        drawMenu = new DrawMenu(menuModel);
    }

    @Test
    public void testDraw() {
        when(menuModel.getText()).thenReturn("Test Menu");
        when(menuModel.getEntryName(0)).thenReturn("Option 1");
        when(menuModel.getEntryName(1)).thenReturn("Option 2");
        when(menuModel.getEntryName(2)).thenReturn("Option 3");
        when(menuModel.getEntryName(3)).thenReturn("Option 4");
        when(menuModel.getEntryName(4)).thenReturn("EXIT");
        when(menuModel.isSelected(0)).thenReturn(true);
        when(menuModel.isSelected(1)).thenReturn(false);
        when(menuModel.isSelected(2)).thenReturn(false);
        when(menuModel.isSelected(3)).thenReturn(false);
        when(menuModel.isSelected(4)).thenReturn(false);

        drawMenu.draw(gui);

        verify(gui).drawTitle("Test Menu");
        verify(gui).drawTextSelected(new PositionModel(34, 15 + 1), "Option 1", new TextColor.RGB(0, 255, 0));
        verify(gui).drawText(new PositionModel(34, 15 + 4 + 1), "Option 2", new TextColor.RGB(255, 255, 255));
        verify(gui).drawText(new PositionModel(34, 15 + 4 * 2 + 1), "Option 3", new TextColor.RGB(255, 255, 255));
        verify(gui).drawText(new PositionModel(34, 15 + 4 * 3 + 1), "Option 4", new TextColor.RGB(255, 255, 255));
        verify(gui).drawText(new PositionModel(35, 15 + 4 * 4 + 1), "EXIT", new TextColor.RGB(255, 255, 255));
        verifyNoMoreInteractions(gui);
    }
}