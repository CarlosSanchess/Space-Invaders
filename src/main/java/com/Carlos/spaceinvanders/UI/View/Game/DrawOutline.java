package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Models.Model.WallModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;

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
