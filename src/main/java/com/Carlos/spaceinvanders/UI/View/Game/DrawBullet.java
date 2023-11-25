package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Models.Model.BulletModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
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
