package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Models.Model.BulletModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;

import java.util.List;

public class DrawBullets extends Viewer<List<BulletModel>> implements DrawElement {

    public DrawBullets(List<BulletModel> bullets){
        super(bullets);
    }

    @Override
    public void draw(LanternaGui GUI){
        for (BulletModel bulletModel : super.getModel()) {
            DrawBullet drawBullet = new DrawBullet(bulletModel);
            drawBullet.draw(GUI);
        }
    }
}

