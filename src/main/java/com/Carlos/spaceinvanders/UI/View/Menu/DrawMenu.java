package com.Carlos.spaceinvanders.UI.View.Menu;

import com.Carlos.spaceinvanders.Entities.Model.MenuModel;
import com.Carlos.spaceinvanders.Entities.Model.PositionModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
import com.googlecode.lanterna.TextColor;

import java.util.List;

public class DrawMenu extends Viewer<MenuModel> {

    public DrawMenu(MenuModel menuModel) {
        super(menuModel);
    }

    @Override
    public void draw(LanternaGui gui) {
        MenuModel menuModel = getModel(); // Get the menu model
        String title = menuModel.getText(); // Get the menu string from the model
        TextColor.RGB textColor = new TextColor.RGB(178, 73, 210);

        String[] lines = title.split("\n");
        int y = 0;
        for (String line : lines) {
            gui.drawText(new PositionModel(7, y), line, textColor);
            y++;
        }
    }
}
