package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;

import com.Carlos.spaceinvaders.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameController extends Controller<ArenaModel> {
    PlayerController playerController;
    BulletsController bulletsController;
    private MonsterControllerFactory monsterControllerFactory;

    public GameController(ArenaModel arenaModel) {
        super(arenaModel);

        this.playerController = new PlayerController(getModel().getPlayer(), getModel().getWidth(), arenaModel.getActiveBullets()); //Passar a arena?
        this.bulletsController = new BulletsController(getModel().getActiveBullets());
        this.monsterControllerFactory = new MonsterControllerFactory(getModel().getWidth(), getModel().getActiveBullets(), getModel().getActiveMonsters());

    }
    public void toDo(Game game,String keyPressed, long Time){

            if(!Objects.equals(keyPressed, null)){
                playerController.toDo(game,keyPressed,Time);
            }
            bulletsController.toDo(game,keyPressed,Time); // Nao espera por nenhum keyboard input

            for (MonsterController monsterController : monsterControllerFactory.getMonstersControllers()) {
                monsterController.toDo(game,null,Time);
            }
    }
}