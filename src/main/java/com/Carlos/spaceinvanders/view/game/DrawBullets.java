package com.Carlos.spaceinvanders.view.game;

import com.Carlos.spaceinvanders.model.models.BulletModel;
import com.Carlos.spaceinvanders.gui.LanternaGui;
import com.Carlos.spaceinvanders.view.Viewer;

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

