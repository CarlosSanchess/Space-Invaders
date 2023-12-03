package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameController extends Controller<ArenaModel> {
    PlayerModel playerModel;
    PlayerController playerController;
    BulletsController bulletsController;
    private MonsterControllerFactory monsterControllerFactory;

    private List<MonsterController> monsterControllers;
    public GameController(ArenaModel arenaModel) {
        super(arenaModel);

        this.playerController = new PlayerController(getModel().getPlayer(), getModel().getWidth(), arenaModel.getActiveBullets());
        this.bulletsController = new BulletsController(getModel().getActiveBullets());
        this.monsterControllerFactory = new MonsterControllerFactory(getModel().getWidth(),getModel().getActiveBullets());

        this.monsterControllers = new ArrayList<>();
        for (MonsterModel monster : arenaModel.getActiveMonsters()) {
            MonsterController monsterController = monsterControllerFactory.createMonsterController(monster);
            this.monsterControllers.add(monsterController);
        }
    }
    public void toDo(String keyPressed, long Time){

            if(!Objects.equals(keyPressed, null)){
                playerController.toDo(keyPressed,Time);
            }
            bulletsController.toDo(keyPressed,Time); // Nao espera por nenhum keyboard input
            for (MonsterController monsterController : monsterControllers) {
                monsterController.toDo(null,Time);
            }
    }
}