package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Entities.Model.ScoreModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawScore  extends Viewer<ScoreModel> {
    DrawScore(ScoreModel scoreModel){
        super(scoreModel);
    }


    @Override
    public void draw(LanternaGui GUI){
        ScoreModel scoreModel = super.getModel();
        GUI.drawText(scoreModel.getPosition(),scoreModel.toString(),new TextColor.RGB(255,255,255));
    }
}
