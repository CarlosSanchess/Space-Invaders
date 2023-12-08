package com.Carlos.spaceinvaders.model.models;

import com.Carlos.spaceinvaders.HighScore;

public class HighScoresModel {
    private final String entry;
    private String filePath = HighScore.absolutePath;


    public HighScoresModel(){
        this.entry = "Exit";
    }

    public String getEntryName(){
        return entry;
    }
    public String getFilePath() {
        return filePath;
    }

}
