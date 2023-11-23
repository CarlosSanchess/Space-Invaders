package com.Carlos.spaceinvanders.UI.View.Game;
import com.Carlos.spaceinvanders.Entities.Model.WallModel;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class DrawOutline implements DrawEntities {

    List<WallModel> outLine;
    public DrawOutline(List<WallModel> outLine){
        this.outLine = outLine;
    }
    @Override
    public void draw(TextGraphics graphics){
        for(WallModel wall: outLine){
            DrawWall drawWall = new DrawWall(wall);
            drawWall.draw(graphics);
        }
    }

}
