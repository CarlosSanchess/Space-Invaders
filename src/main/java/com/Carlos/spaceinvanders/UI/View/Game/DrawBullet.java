package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Entities.Model.BulletModel;
import com.Carlos.spaceinvanders.Entities.Model.PlayerModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.swing.text.View;

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
