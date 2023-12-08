package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.OptionsModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DrawOptionsTest {

    @Mock
    private OptionsModel mockOptionsModel;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDraw() {
        LanternaGui mockGui = mock(LanternaGui.class);
        DrawOptions drawOptions = new DrawOptions(mockOptionsModel);

        drawOptions.draw(mockGui);

        verify(mockGui).drawText(new PositionModel(34, 7), "O", new TextColor.RGB(178, 73, 210), false);
        verify(mockGui).drawText(new PositionModel(35, 7), "P", new TextColor.RGB(178, 73, 210), false);
        verify(mockGui).drawText(new PositionModel(36, 7), "T", new TextColor.RGB(178, 73, 210), false);
        verify(mockGui).drawText(new PositionModel(37, 7), "I", new TextColor.RGB(178, 73, 210), false);
        verify(mockGui).drawText(new PositionModel(38, 7), "O", new TextColor.RGB(178, 73, 210), false);
        verify(mockGui).drawText(new PositionModel(39, 7), "N", new TextColor.RGB(178, 73, 210), false);
        verify(mockGui).drawText(new PositionModel(40, 7), "S", new TextColor.RGB(178, 73, 210), false);
        verify(mockGui).drawText(new PositionModel(35, 19), mockOptionsModel.getEntryName(), new TextColor.RGB(255, 0, 0), false);
    }
}