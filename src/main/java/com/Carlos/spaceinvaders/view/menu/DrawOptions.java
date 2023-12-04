package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.Options;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawOptions extends Viewer<Options> {

    public DrawOptions(Options option){
        super(option);
    }

    @Override
    protected void draw(LanternaGui gui) {
        gui.drawText(new PositionModel(34, 7), "O", new TextColor.RGB(1, 3 ,39), false);
        gui.drawText(new PositionModel(35, 7), "P",  new TextColor.RGB(1, 3 ,39), false);
        gui.drawText(new PositionModel(36, 7), "T",  new TextColor.RGB(1, 3 ,39), false);
        gui.drawText(new PositionModel(37, 7), "I",  new TextColor.RGB(1, 3 ,39), false);
        gui.drawText(new PositionModel(38, 7), "O",  new TextColor.RGB(1, 3 ,39), false);
        gui.drawText(new PositionModel(39, 7), "N",  new TextColor.RGB(1, 3 ,39), false);
        gui.drawText(new PositionModel(40, 7), "S",  new TextColor.RGB(1, 3 ,39), false);

        gui.drawText(new PositionModel(35, 19), getModel().getEntryName(),  new TextColor.RGB(1, 3 ,39), false);
    }
}