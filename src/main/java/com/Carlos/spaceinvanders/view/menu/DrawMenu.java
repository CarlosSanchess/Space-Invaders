package com.Carlos.spaceinvanders.view.menu;

import com.Carlos.spaceinvanders.model.models.MenuModel;
import com.Carlos.spaceinvanders.gui.LanternaGui;
import com.Carlos.spaceinvanders.view.Viewer;

public class DrawMenu extends Viewer<MenuModel> {


    public DrawMenu(MenuModel menuModel) {
        super(menuModel);
    }

    @Override
    public void draw(LanternaGui GUI) {
        MenuModel menuModel = super.getModel();
        String title = menuModel.getText();
        GUI.drawTitle(title);
        GUI.drawEntries(menuModel);
    }
}
