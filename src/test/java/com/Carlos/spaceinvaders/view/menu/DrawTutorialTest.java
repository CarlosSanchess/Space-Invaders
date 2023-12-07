package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.TutorialModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class DrawTutorialTest {

    @Test
    public void testDraw() {
        LanternaGui gui = mock(LanternaGui.class);

        TutorialModel tutorialModel = new TutorialModel();

        DrawTutorial drawTutorial = new DrawTutorial(tutorialModel);

        drawTutorial.draw(gui);

        verify(gui).drawText(new PositionModel(34, 7), "C", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(35, 7), "O", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(36, 7), "N", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(37, 7), "T", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(38, 7), "R", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(39, 7), "O", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(40, 7), "L", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(41, 7), "S", new TextColor.RGB(178, 73 ,210));

        verify(gui).drawText(new PositionModel(29, 10), "UP/SPACE", new TextColor.RGB(255, 255 ,0));
        verify(gui).drawText(new PositionModel(38, 10), "SHOOT", new TextColor.RGB(255, 255 ,255));
        verify(gui).drawText(new PositionModel(29, 12), "LEFT", new TextColor.RGB(255, 255 ,0));
        verify(gui).drawText(new PositionModel(38, 12), "MOVE LEFT",new TextColor.RGB(255, 255 ,255));
        verify(gui).drawText(new PositionModel(29, 14), "RIGHT", new TextColor.RGB(255, 255 ,0));
        verify(gui).drawText(new PositionModel(38, 14), "MOVE RIGHT",new TextColor.RGB(255, 255 ,255));

        verify(gui).drawText(new PositionModel(29, 20), "Q/ESC", new TextColor.RGB(255, 255 ,0));
        verify(gui).drawText(new PositionModel(38, 20), "OPEN IN GAME MENU",new TextColor.RGB(255, 255 ,255));

        verify(gui).drawText(new PositionModel(36, 31), tutorialModel.getEntryName(),new TextColor.RGB(255, 0 ,0));
    }
}