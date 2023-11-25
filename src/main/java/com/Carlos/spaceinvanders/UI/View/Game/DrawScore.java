package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Models.Model.ScoreModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawScore  extends Viewer<ScoreModel> implements DrawElement {
    DrawScore(ScoreModel scoreModel){
        super(scoreModel);
    }


    @Override
    public void draw(LanternaGui GUI){
        ScoreModel scoreModel = super.getModel();
        int score = scoreModel.getScore();
        GUI.drawText(scoreModel.getPosition(),Integer.toString(score),new TextColor.RGB(255,255,255));
    }
}
