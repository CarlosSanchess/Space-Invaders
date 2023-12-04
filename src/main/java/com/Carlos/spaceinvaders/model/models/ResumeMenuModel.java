package com.Carlos.spaceinvaders.model.models;

import com.googlecode.lanterna.TextColor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeMenuModel implements Model{
    static String text = " ___          ____                      \n" +
            "|_ _|_ __    / ___| __ _ _ __ ___   ___ \n" +
            " | || '_ \\  | |  _ / _` | '_ ` _ \\ / _ \\\n" +
            " | || | | | | |_| | (_| | | | | | |  __/\n" +
            "|___|_| |_|  \\____|\\__,_|_| |_| |_|\\___|\n";



    private final List<String> entries;
    private int entry = 0; // Selecionado
    private final Map<String, TextColor.RGB> entryColors;

    public ResumeMenuModel(){
        this.entries = Arrays.asList("RESUME","RESTART","SAVE PROGRESS","GO TO MAIN MENU");
        entry = 0;
        entryColors = new HashMap<>();
        entryColors.put("RESUME",new TextColor.RGB(255,0,0)); // Red
        entryColors.put("RESTART", new TextColor.RGB(0,255,0)); // Green
        entryColors.put("SAVE/LOAD",new TextColor.RGB(0,0,255)); // Blue
        entryColors.put("EXIT", new TextColor.RGB(255,255,0)); // Yellow
    }
    public int getNumEntries() {
        return entries.size();
    }

    public String getEntryName(int i){
        return entries.get(i);
    }

    public List<String> getEntries() {
        return entries;
    }
    public TextColor.RGB getColor(String entry) {
        return entryColors.get(entry);
    }
    public int getEntry(){
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    public int getEntriesSize(){
        return entries.size();
    }
    public String getText(){
        return text;
    }

    public void setText(String spaceInvaders) {
        this.text = spaceInvaders;
    }

    public void addEntry(String newGame, TextColor.RGB rgb) { // Not Used Yet
        this.entries.add(newGame);
        this.entryColors.put(newGame,rgb);
    }

    public boolean isSelected(int i){
        return i == getCurrentEntry();
    }

    public int getCurrentEntry() {
        return entry;
    }
}
