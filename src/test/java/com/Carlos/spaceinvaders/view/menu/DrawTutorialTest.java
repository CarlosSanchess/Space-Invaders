package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.TutorialModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class DrawTutorialTest {

    private DrawTutorial drawTutorial;
    private TutorialModel tutorialModel;

    @BeforeEach
    public void setUp() {
        tutorialModel = mock(TutorialModel.class);
        drawTutorial = new DrawTutorial(tutorialModel);
    }

    @Test
    public void testDraw() {
        LanternaGui gui = mock(LanternaGui.class);

        drawTutorial.draw(gui);

        verify(gui).drawText(new PositionModel(34, 7-2), "C", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(35, 7-2), "O", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(36, 7-2), "N", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(37, 7-2), "T", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(38, 7-2), "R", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(39, 7-2), "O", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(40, 7-2), "L", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(41, 7-2), "S", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(29, 10-2), "UP/SPACE", new TextColor.RGB(255, 255 ,0));
        verify(gui).drawText(new PositionModel(38, 10-2), "SHOOT", new TextColor.RGB(255, 255 ,255));
        verify(gui).drawText(new PositionModel(29, 12-2), "LEFT", new TextColor.RGB(255, 255 ,0));
        verify(gui).drawText(new PositionModel(38, 12-2), "MOVE LEFT",new TextColor.RGB(255, 255 ,255));
        verify(gui).drawText(new PositionModel(29, 14-2), "RIGHT", new TextColor.RGB(255, 255 ,0));
        verify(gui).drawText(new PositionModel(38, 14-2), "MOVE RIGHT",new TextColor.RGB(255, 255 ,255));
        verify(gui).drawText(new PositionModel(29, 16-2), "Q/ESC", new TextColor.RGB(255, 255 ,0));
        verify(gui).drawText(new PositionModel(38, 16-2), "OPEN IN GAME MENU",new TextColor.RGB(255, 255 ,255));
        verify(gui).drawText(new PositionModel(34, 19-2), "GAME INFO", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(29, 22-2), "]", new TextColor.RGB(255, 0 ,0));
        verify(gui).drawText(new PositionModel(38, 22-2), "KILL THE MONSTERS",new TextColor.RGB(255, 255 ,255));
        verify(gui).drawText(new PositionModel(29, 24-2), "+", new TextColor.RGB(0, 255 ,0));
        verify(gui).drawText(new PositionModel(31, 24-2), "★", new TextColor.RGB(255, 255 ,0));
        verify(gui).drawText(new PositionModel(33, 24-2), "F", new TextColor.RGB(255, 0 ,0));
        verify(gui).drawText(new PositionModel(38, 24-2), "SHOOT THE POWERUPS TO GAIN POWERS",new TextColor.RGB(255, 255 ,255));
        verify(gui).drawText(new PositionModel(35, 27-2), "POWERUPS", new TextColor.RGB(178, 73 ,210));
        verify(gui).drawText(new PositionModel(29, 30-2), "+", new TextColor.RGB(0, 255 ,0));
        verify(gui).drawText(new PositionModel(38, 30-2), "EXTRA LIFE",new TextColor.RGB(255, 255 ,255));
        verify(gui).drawText(new PositionModel(29, 32-2), "★", new TextColor.RGB(255, 255 ,0));
        verify(gui).drawText(new PositionModel(38, 32-2), "5X SCORE BOOST",new TextColor.RGB(255, 255 ,255));
        verify(gui).drawText(new PositionModel(29, 34-2), "F", new TextColor.RGB(255, 0 ,0));
        verify(gui).drawText(new PositionModel(38, 34-2), "FIRE RATE BOOST",new TextColor.RGB(255, 255 ,255));
        verify(gui).drawText(new PositionModel(36, 36), tutorialModel.getEntryName(), new TextColor.RGB(255, 0 ,0));
    }
}