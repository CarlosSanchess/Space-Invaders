package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DrawMenu extends Viewer<MenuModel> {

    MenuModel menuModel;
    public DrawMenu(MenuModel menuModel) {
        super(menuModel);
    }

    @Override
    public void draw(LanternaGui GUI) {
        menuModel = super.getModel();
        String title = menuModel.getText();
        GUI.drawTitle(title);
        GUI.drawEntries(menuModel);
        GUI.drawSelected(menuModel); //Ter a declaração em GUI,
    }

    private void drawTop(TextGraphics graphics){ //Fazer assim ou no Lanterna GUi para manter coerencia?
        //Get entries start Point
        // Draw Lines
        String Entry = menuModel.getEntries().get(menuModel.getEntry());



    }

}
