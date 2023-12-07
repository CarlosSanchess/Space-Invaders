package com.Carlos.spaceinvaders.model.models;

public class HighScoresModel {
    private final String entry;

    public HighScoresModel(){
        this.entry = "Exit";
    }

    public String getEntryName(){
        return entry;
    }
}
