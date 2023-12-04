package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.GameOverMenuModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.GameOverMenuModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawGameOverMenu extends Viewer<GameOverMenuModel> {
    private GameOverMenuModel resumeMenuModel;
    public DrawGameOverMenu(GameOverMenuModel resumeMenuModel) {
        super(resumeMenuModel);
        this.resumeMenuModel = resumeMenuModel;
    }

    @Override
    public void draw(LanternaGui GUI) {



        resumeMenuModel = getModel();
        String title = resumeMenuModel.getText();
        GUI.drawTitle(title);

        for (int i = 0; i < 2; i++) {
            String entryName = getModel().getEntryName(i);
            PositionModel position;
            if ("EXIT".equals(entryName)) {
                position = new PositionModel(36, 15 + 4 * i);
            }else {
                position = new PositionModel(34, 15 + 4 * i);
            }

            if (getModel().isSelected(i)) {
                GUI.drawTextSelected(position, entryName, new TextColor.RGB(0, 255 ,0));
            } else {
                GUI.drawText(position, entryName, new TextColor.RGB(255, 255 ,255));
            }
        }
    }
}
