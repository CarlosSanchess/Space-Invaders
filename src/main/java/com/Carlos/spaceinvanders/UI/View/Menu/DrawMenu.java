package com.Carlos.spaceinvanders.UI.View.Menu;

import com.Carlos.spaceinvanders.Entities.Model.MenuModel;
import com.Carlos.spaceinvanders.Entities.Model.PositionModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawMenu extends Viewer<MenuModel> {

    private MenuModel menuModel;

    public DrawMenu(MenuModel menuModel){
        super(menuModel);

    }
    @Override
    public void draw(LanternaGui GUI){
        menuModel = super.getModel();
        GUI.drawText(new PositionModel(10,10),menuModel.getText(), new TextColor.RGB(0,255,0)); // Usar hexadecimal ?
    }
}
