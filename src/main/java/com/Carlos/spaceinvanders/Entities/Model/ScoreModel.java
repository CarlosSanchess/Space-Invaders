package com.Carlos.spaceinvanders.Entities.Model;

public class ScoreModel extends Elements{
    private int score;
    public ScoreModel(PositionModel position){
        super(position);
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
