package com.Carlos.spaceinvanders.view.game;

import com.Carlos.spaceinvanders.model.models.ScoreModel;
import com.Carlos.spaceinvanders.gui.LanternaGui;
import com.Carlos.spaceinvanders.view.Viewer;
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
