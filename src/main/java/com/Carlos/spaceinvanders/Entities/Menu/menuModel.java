package com.Carlos.spaceinvanders.Entities.Menu;

import com.Carlos.spaceinvanders.Entities.Builders.menuString;

//TODO
//Organizar o codigo do menu retirar os atributos da classe menu do draw Menu
//TAlvez ter aqui os atributos com getters

public class menuModel {
    private String title;


    enum Options{
        NEWGAME,
        MYSPACESHIP,
        TUTORIAL,
        OPTIONS,
        EXIT
    }

    public menuModel(){
        this.title = menuString.getTitle();
    }

    public String getTitle() {
        return title;
    }

    public String getStartGame() {
        return "NEW GAME";
    }
    public String getMySpaceShip(){
        return "MY SPACESHIP";
    }
    public String Tutorial(){
        return "Tutorial";
    }
    public String Options(){
        return "Options";
    }
    public String Exit(){
        return "Exit";
    }

}
