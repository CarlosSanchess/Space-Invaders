package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class DrawMenuTest {

    @Mock
    private LanternaGui guiMock;

    private DrawMenu drawMenu;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        MenuModel menuModel = new MenuModel();
        drawMenu = new DrawMenu(menuModel);
    }

    @Test
    public void testDraw() {
        MenuModel menuModel = drawMenu.getModel();
        menuModel.setText("Space Invaders");

        drawMenu.draw(guiMock);

        verify(guiMock).drawTitle("Space Invaders");
        verify(guiMock).drawEntries(menuModel);
    }
}
