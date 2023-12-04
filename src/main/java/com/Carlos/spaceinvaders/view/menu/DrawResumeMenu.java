package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.ResumeMenuModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.ResumeMenuModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawResumeMenu extends Viewer<ResumeMenuModel> {

    private ResumeMenuModel resumeMenuModel;
    public DrawResumeMenu(ResumeMenuModel resumeMenuModel) {
        super(resumeMenuModel);
        this.resumeMenuModel = resumeMenuModel;
    }

    @Override
    public void draw(LanternaGui GUI) {



        resumeMenuModel = getModel();
        String title = resumeMenuModel.getText();
        GUI.drawTitle(title);

        for (int i = 0; i < 4; i++) {
            String entryName = getModel().getEntryName(i);
            PositionModel position;
            if ("EXIT".equals(entryName)) {
                position = new PositionModel(35, 15 + 4 * i);
            }else if ("SAVE/LOAD".equals(entryName)) {
                position = new PositionModel(33, 15 + 4 * i);
            } else {
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
