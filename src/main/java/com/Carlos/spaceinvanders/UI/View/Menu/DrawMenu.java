package com.Carlos.spaceinvanders.UI.View.Menu;

import com.Carlos.spaceinvanders.Entities.Model.MenuModel;
import com.Carlos.spaceinvanders.Entities.Model.PositionModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawMenu extends Viewer<MenuModel> {

    MenuModel menuModel;
    public DrawMenu(MenuModel menuModel){
        super(menuModel);
        menuModel = super.getModel();

    }
    @Override
    public void draw(LanternaGui GUI) {
        String title = menuModel.getText();
        GUI.drawTitle(title);
    }

}
