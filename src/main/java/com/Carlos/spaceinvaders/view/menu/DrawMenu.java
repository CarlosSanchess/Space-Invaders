package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;

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
