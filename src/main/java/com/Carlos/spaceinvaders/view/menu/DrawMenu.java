package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DrawMenu extends Viewer<MenuModel> {

    private MenuModel menuModel;
    public DrawMenu(MenuModel menuModel) {
        super(menuModel);
        this.menuModel = menuModel;
    }

    @Override
    public void draw(LanternaGui GUI) {



        menuModel = getModel();
        String title = menuModel.getText();
        GUI.drawTitle(title);

        for (int i = 0; i < 5; i++) {
            String entryName = getModel().getEntryName(i);
            PositionModel position;
            if ("EXIT".equals(entryName)) {
                position = new PositionModel(35, 15 + 4 * i+1);
            } else if ("CONTINUE GAME". equals(entryName)) {
                position = new PositionModel(31, 15 + 4 * i+1);
            } else {
                position = new PositionModel(34, 15 + 4 * i+1);
            }

            if (getModel().isSelected(i)) {
                GUI.drawTextSelected(position, entryName, new TextColor.RGB(0, 255 ,0));
            } else {
                GUI.drawText(position, entryName, new TextColor.RGB(255, 255 ,255));
            }
        }
    }

    private void drawTop(TextGraphics graphics){ //Fazer assim ou no Lanterna GUi para manter coerencia?
        //Get entries start Point
        // Draw Lines
        String Entry = menuModel.getEntries().get(menuModel.getEntry());



    }

}
