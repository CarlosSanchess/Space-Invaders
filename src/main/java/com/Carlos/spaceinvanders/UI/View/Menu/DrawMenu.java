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
    }
}
