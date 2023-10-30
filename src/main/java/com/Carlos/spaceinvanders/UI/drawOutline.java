package com.Carlos.spaceinvanders.UI;
import com.Carlos.spaceinvanders.Entities.wallModel;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class drawOutline implements drawEntities{

    List<wallModel> outLine;
    public drawOutline(List<wallModel> outLine){
        this.outLine = outLine;
    }
    @Override
    public void draw(TextGraphics graphics){
        for(wallModel wall: outLine){
            drawWall drawWall = new drawWall(wall);
            drawWall.draw(graphics);
        }
    }

}
