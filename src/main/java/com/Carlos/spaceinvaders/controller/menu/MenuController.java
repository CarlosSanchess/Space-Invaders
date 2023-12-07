package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.*;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.controller.SoundController;
import com.Carlos.spaceinvaders.model.models.*;

import java.util.Objects;

public class MenuController extends Controller<MenuModel> {
    //TODO TORNAR MAIS LEGIVEL
    private MenuModel menuModel;
    private SoundController soundController;

    public MenuController(MenuModel menuModel){
        super(menuModel);
        this.soundController = soundController;
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

    private void Select(Game game){
        int entry = getModel().getEntry();

        if(entry == 0) newGame(game);
        if(entry == 1) continueGame(game);
        if(entry == 2) tutorial(game);
        if(entry == 3) highscores(game);
        if(entry == 4) exit(game);

    }


    public void toDo(Game game, String keyPressed, long Time){ // TODO FAZ SENTIDO TER O TIME AQUI?
        if(Objects.equals(keyPressed, "ArrowDown")) nextEntry();
        if(Objects.equals(keyPressed,"ArrowUp")) previousEntry();
        if(Objects.equals(keyPressed,"Enter")) Select(game);
        if(Objects.equals(keyPressed,"Quit")) playerName(game);
    }

    private void playerName(Game game){
        game.pushState(new PlayerNameState(new PlayerNameModel())); // talvez vá haver um problema com os nomes, por na estar a dar Pop do menu anterior
    }
    private void newGame(Game game) {
        game.pushState(new GameState(new ArenaModel(game.getScreenSize().getX() / 25, game.getScreenSize().getY() / 25)));
        // soundController.playSound("Menu");
    }
    private void continueGame( Game game){
        while (game.getCurrentState() != null && !(game.getCurrentState() instanceof GameState)) {
            game.popState();
        }

        if (game.getCurrentState() instanceof GameState) {
            GameState gameState = (GameState) game.getCurrentState();
            game.popState(); // Remove the GameState from the stack
            game.pushState(gameState);
        } else {

            game.pushState(new MenuState(new MenuModel()));
        }
    }

    private void tutorial(Game game){

        game.pushState(new TutorialState(new TutorialModel()));
    }
    private void highscores(Game game){

        game.pushState(new HighScoresState(new HighScoresModel()));
    }

    private void exit(Game game){
        System.exit(0);
    }

}
