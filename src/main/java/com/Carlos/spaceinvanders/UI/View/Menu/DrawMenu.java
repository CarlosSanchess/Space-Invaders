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
    public void draw(LanternaGui GUI) {
        MenuModel menuModel = super.getModel();
        String title = menuModel.getText();
        GUI.drawTitle(title);

        List<String> entries = menuModel.getEntries();
        int y = 10;
        for (String entry : entries) {
                TextColor.RGB color = menuModel.getColor(entry);
                GUI.drawText(new PositionModel(33, y), entry, color); 
                y += 3;
        }
    }
}
