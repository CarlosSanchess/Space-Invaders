package com.Carlos.spaceinvanders.view.game;

import com.Carlos.spaceinvanders.model.models.WallModel;
import com.Carlos.spaceinvanders.gui.LanternaGui;
import com.Carlos.spaceinvanders.view.Viewer;

import java.util.List;


public class DrawOutline extends Viewer<List<WallModel>> implements DrawElement {

    public DrawOutline(List<WallModel> walls){
        super(walls);
    }

    @Override
    public void draw(LanternaGui GUI){
        for(WallModel wallModel : super.getModel()){
            DrawWall drawWall = new DrawWall(wallModel);
            drawWall.draw(GUI);
        }
    }
}
