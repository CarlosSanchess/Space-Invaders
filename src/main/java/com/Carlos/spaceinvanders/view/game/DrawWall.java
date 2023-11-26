package com.Carlos.spaceinvanders.view.game;
import com.Carlos.spaceinvanders.model.models.WallModel;
import com.Carlos.spaceinvanders.gui.LanternaGui;
import com.Carlos.spaceinvanders.view.Viewer;
import com.googlecode.lanterna.TextColor;


public class DrawWall extends Viewer<WallModel> implements DrawElement {

    public DrawWall(WallModel wall){
        super(wall);
    }

    @Override
    public void draw(LanternaGui GUI) {
        WallModel wallModel = super.getModel();
        GUI.drawText(wallModel.getPosition(),"*",new TextColor.RGB(255,255,255));
        }
    }

