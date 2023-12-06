package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;

import com.Carlos.spaceinvaders.HighScore;
import com.Carlos.spaceinvaders.State.GameOverMenuState;
import com.Carlos.spaceinvaders.State.ResumeMenuState;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;

import com.Carlos.spaceinvaders.model.models.GameOverMenuModel;
import com.Carlos.spaceinvaders.model.models.ResumeMenuModel;


public class GameController extends Controller<ArenaModel> {
    PlayerController playerController;
    BulletsController bulletsController;
    private final MonsterControllerFactory monsterControllerFactory;

    public GameController(ArenaModel arenaModel) {
        super(arenaModel);

        this.playerController = new PlayerController(getModel().getPlayer(), getModel().getWidth(), arenaModel.getActiveBullets()); //Passar a arena?
        this.bulletsController = new BulletsController(getModel().getActiveBullets(), getModel().getActiveMonsters(), getModel().getPlayer(), getModel().getScore());
        this.monsterControllerFactory = new MonsterControllerFactory(getModel().getWidth(), getModel().getActiveBullets(), getModel().getActiveMonsters());

    }
    public void toDo(Game game,String keyPressed, long Time){

        if (keyPressed != null && (keyPressed.equals("Escape") || keyPressed.equals("Quit")) ) {
            game.pushState(new ResumeMenuState(new ResumeMenuModel()));
        }
        playerController.toDo(game,keyPressed,Time);
        bulletsController.toDo(game,keyPressed,Time); // Nao espera por nenhum keyboard input
        for (MonsterController monsterController : monsterControllerFactory.getMonstersControllers()) {
            monsterController.toDo(game,null,Time);
        }

        endGame(game);
    }

    private void endGame(Game game){
        if(getModel().getPlayer().getHitPoints() <= 0) {
            game.pushState(new GameOverMenuState(new GameOverMenuModel()));

            int finalScore = getModel().getScore().getScore();
            int highScore = HighScore.loadHighScore();

            if (finalScore > highScore) {
                HighScore.saveHighScore(finalScore);
            }
        }
    }
}