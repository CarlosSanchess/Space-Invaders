package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawBullet extends Viewer<BulletModel> {


    public DrawBullet(BulletModel bulletModel){
       super(bulletModel);
    }

    @Override
    public void draw(LanternaGui GUI){
        BulletModel monsterModel = getModel();
        GUI.drawText(monsterModel.getPosition(),"|",new TextColor.RGB(255,0,0));
    }
}
