package com.Carlos.spaceinvanders.Entities.Menu;

import com.Carlos.spaceinvanders.Entities.Builders.menuString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO
//Organizar o codigo do menu retirar os atributos da classe menu do draw Menu
//TAlvez ter aqui os atributos com getters

public class MenuModel {
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



}
