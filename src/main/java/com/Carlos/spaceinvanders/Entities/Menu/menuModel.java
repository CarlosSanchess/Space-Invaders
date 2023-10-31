package com.Carlos.spaceinvanders.Entities.Menu;

import com.Carlos.spaceinvanders.Entities.Builders.menuString;

//TODO
//Organizar o codigo do menu retirar os atributos da classe menu do draw Menu
//TAlvez ter aqui os atributos com getters

public class menuModel {
    private String title;
    private  String startGame;

    public menuModel(){
        this.title = menuString.getTitle();
        this.startGame = menuString.getStartGame();
    }

    public String getTitle() {
        return title;
    }

    public String getStartGame() {
        return startGame;
    }
}
