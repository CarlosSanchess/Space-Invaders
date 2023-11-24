package com.Carlos.spaceinvanders.Entities.Model;

import java.util.Arrays;
import java.util.List;

//TODO
//Organizar o codigo do menu retirar os atributos da classe menu do draw Menu
//TAlvez ter aqui os atributos com getters

public class MenuModel {
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
    public MenuModel(){
        this.entries = Arrays.asList("NEW GAME,TUTORIAL,OPTIONS,EXIT");
        entry = 0;
    }
    public void nextEntry(){
        entry = (entry + 1) % entries.size();
    }
    public void previousEntry(){
        entry = (entry - 1) % entries.size();
    }
    public int getEntry(){
        return entry;
    }

    public String getText(){
        return text;
    }

}
