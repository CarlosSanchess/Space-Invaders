package com.Carlos.spaceinvanders.UI.View.Menu;

import com.Carlos.spaceinvanders.Models.Model.MenuModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;

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
