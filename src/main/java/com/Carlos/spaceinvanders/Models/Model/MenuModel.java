package com.Carlos.spaceinvanders.Models.Model;

import com.googlecode.lanterna.TextColor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO
//Organizar o codigo do menu retirar os atributos da classe menu do draw Menu
//TAlvez ter aqui os atributos com getters

public class MenuModel implements Model{
    static String text =
            "                          _                     _               \n" +
                    "                         (_)                   | |              \n" +
                    " ___ _ __   __ _  ___ ___ _ _ ____   ____ _  __| | ___ _ __ ___ \n" +
                    "/ __| '_ \\ / _` |/ __/ _ \\ | '_ \\ \\ / / _` |/ _` |/ _ \\ '__/ __|\n" +
                    "\\__ \\.|_) | (_| | (_|  __/ | | | \\ V / (_| | (_| |  __/ |  \\__ \\\n" +
                    "|___/ .__/ \\__,_|\\___\\___|_|_| |_|\\_/ \\__,_|\\__,_|\\___|_|  |___/\n" +
                    "    | |                                                          \n" +
                    "    |_|                                                          \n";

    private final List<String> entries;
    private int entry = 0; // Selecionado
    private final Map<String, TextColor.RGB> entryColors;
    
    public MenuModel(){
        this.entries = Arrays.asList("NEW GAME","TUTORIAL","OPTIONS","EXIT");
        entry = 0;
        entryColors = new HashMap<>();
        entryColors.put("NEW GAME",new TextColor.RGB(255,0,0)); // Red
        entryColors.put("TUTORIAL", new TextColor.RGB(0,255,0)); // Green
        entryColors.put("OPTIONS",new TextColor.RGB(0,0,255)); // Blue
        entryColors.put("EXIT", new TextColor.RGB(255,255,0)); // Yellow
    }
    public void nextEntry(){
        entry = (entry + 1) % entries.size();
    }
    public void previousEntry(){
        entry = (entry - 1) % entries.size();
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

    public String getText(){
        return text;
    }


}
