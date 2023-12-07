package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.HighScoresModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawHighScores extends Viewer<HighScoresModel> {

    public DrawHighScores(HighScoresModel highScores){
        super(highScores);
    }

    @Override
    protected void draw(LanternaGui gui) {
        gui.drawText(new PositionModel(33, 7), "H", new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(34, 7), "I",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(35, 7), "G",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(36, 7), "H",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(37, 7), "S",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(38, 7), "C",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(39, 7), "O",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(40, 7), "R",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(41, 7), "E",  new TextColor.RGB(178, 73 ,210), false);
        gui.drawText(new PositionModel(42, 7), "S",  new TextColor.RGB(178, 73 ,210), false);


        gui.drawText(new PositionModel(35, 19), getModel().getEntryName(),  new TextColor.RGB(255, 0 ,0), false);
    }
}