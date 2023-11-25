package com.Carlos.spaceinvanders.view.game;

import com.Carlos.spaceinvanders.model.models.BulletModel;
import com.Carlos.spaceinvanders.gui.LanternaGui;
import com.Carlos.spaceinvanders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawBullet extends Viewer<BulletModel> {


    public DrawBullet(BulletModel bulletModel){
       super(bulletModel);
    }

    @Override
    public void draw(LanternaGui GUI){
        BulletModel monsterModel = super.getModel();
        GUI.drawText(monsterModel.getPosition(),"|",new TextColor.RGB(255,0,0));
    }
}
