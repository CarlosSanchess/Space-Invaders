package com.Carlos.spaceinvanders.UI.View.Game;
import com.Carlos.spaceinvanders.Entities.Model.WallModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
import com.googlecode.lanterna.TextColor;


public class DrawWall extends Viewer<WallModel> {

    public DrawWall(WallModel wall){
        super(wall);
    }

    @Override
    public void draw(LanternaGui GUI) {
        WallModel monsterModel = super.getModel();
        GUI.drawText(monsterModel.getPosition(),"*",new TextColor.RGB(255,105,97));
        }
    }

