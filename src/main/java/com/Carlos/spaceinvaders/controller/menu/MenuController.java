package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.GameState;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.MenuModel;

import java.util.Objects;

public class MenuController extends Controller<MenuModel> {
    //TODO TORNAR MAIS LEGIVEL
    private MenuModel menuModel;
    private final Game game;
    
    public MenuController(MenuModel menuModel,Game game){
        super(menuModel);
        this.game = game;
    }

    private void nextEntry(){
        int entry = getModel().getEntry();
        int lenEntries = getModel().getEntriesSize();

        getModel().setEntry((entry + 1) % lenEntries);
    }
    private void previousEntry() {
        if (getModel().getEntry() == 0) {
            getModel().setEntry(getModel().getEntriesSize() - 1);
        } else {
            getModel().setEntry(getModel().getEntry() - 1);
        }
    }

    private void Select(){
        int entry = getModel().getEntry();

        if(entry == 0) newGame();
        if(entry == 1) tutorial();
        if(entry == 2) options();
        if(entry == 3) exit();

    }

    private void tutorial(){
        System.out.println("Tutorial");
    }
    private void options(){
        System.out.println("Options");
    }
    private void exit(){
        System.out.println("Exit");
    }
    public void toDo(String keyPressed, long Time){ // TODO FAZ SENTIDO TER O TIME AQUI?
        if(Objects.equals(keyPressed, "ArrowDown")) nextEntry();
        if(Objects.equals(keyPressed,"ArrowUp")) previousEntry();
        if(Objects.equals(keyPressed,"Enter")) Select();
    }

    private void newGame() {
        game.setState(new GameState(new ArenaModel(game.getScreenSize().getX() / 25, game.getScreenSize().getY() / 25),game));
    }

}
