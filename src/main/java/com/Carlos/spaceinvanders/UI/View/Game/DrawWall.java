package com.Carlos.spaceinvanders.UI.View.Game;
import com.Carlos.spaceinvanders.Entities.Model.WallModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
import com.googlecode.lanterna.TextColor;


public class DrawWall extends Viewer<WallModel> implements DrawElement {

    public DrawWall(WallModel wall){
        super(wall);
    }

    @Override
    public void draw(LanternaGui GUI) {
        WallModel wallModel = super.getModel();
        GUI.drawText(wallModel.getPosition(),"*",new TextColor.RGB(255,255,255),Boolean.FALSE);
        }
    }

