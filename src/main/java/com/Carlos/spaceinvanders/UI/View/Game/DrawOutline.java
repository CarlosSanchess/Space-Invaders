package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Entities.Model.Model;
import com.Carlos.spaceinvanders.Entities.Model.WallModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;

import java.util.List;

public class DrawOutline extends Viewer<List<WallModel>>  {


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
