package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;

import com.Carlos.spaceinvaders.State.ResumeMenuState;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.ResumeMenuModel;

import java.util.Objects;

public class GameController extends Controller<ArenaModel> {
    PlayerController playerController;
    BulletsController bulletsController;
    private final MonsterControllerFactory monsterControllerFactory;
    private final PowerUpFactory  powerUpFactory;

    public GameController(ArenaModel arenaModel) {
        super(arenaModel);

        this.playerController = new PlayerController(getModel().getPlayer(), getModel().getWidth(), arenaModel.getActiveBullets()); //Passar a arena?
        this.bulletsController = new BulletsController(getModel().getActiveBullets(), getModel().getActiveMonsters(), getModel().getPlayer(), getModel().getScore());
        this.monsterControllerFactory = new MonsterControllerFactory(getModel().getWidth(), getModel().getActiveBullets(), getModel().getActiveMonsters());
        this.powerUpFactory = new PowerUpFactory(getModel().getActivePowerUps());
    }
    public void toDo(Game game,String keyPressed, long Time){

        if (keyPressed != null && (keyPressed.equals("Escape") || keyPressed.equals("Quit")) ) {
            game.pushState(new ResumeMenuState(new ResumeMenuModel()));
        }
        powerUpFactory.createPowerUp(Time);
        playerController.toDo(game,keyPressed,Time);
        bulletsController.toDo(game,keyPressed,Time); // Nao espera por nenhum keyboard input
        for (MonsterController monsterController : monsterControllerFactory.getMonstersControllers()) {
            monsterController.toDo(game,null,Time);
        }
        System.out.println(getModel().getPlayer().getHitPoints());
        endGame(game);
    }

    private void endGame(Game game){
        if(getModel().getPlayer().getHitPoints() <= 0) {
            game.popState();
        }
    }
}