package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class GameController extends Controller<ArenaModel> {
    PlayerModel playerModel;
    PlayerController playerController;
    BulletsController bulletsController;
    private MonsterControllerFactory monsterControllerFactory;

    private List<MonsterController> monsterControllers;
    public GameController(ArenaModel arenaModel,MonsterControllerFactory monsterControllerFactory){
        super(arenaModel);
        //this.playerModel = super.getModel().getPlayer();
        this.playerController = new PlayerController(super.getModel().getPlayer(),super.getModel().getWidth(), arenaModel.getActiveBullets());
        this.bulletsController = new BulletsController(super.getModel().getActiveBullets());
        this.monsterControllerFactory = monsterControllerFactory;
        this.monsterControllers = new ArrayList<>();
        Random random = new Random();
        for (MonsterModel monster : arenaModel.getActiveMonsters()) {
            MovementStrategy movementStrategy;
            int randomNumber = random.nextInt(11);
            if (randomNumber < 2) {
                movementStrategy = new ShooterMovementStrategy();
            } else if (randomNumber < 4) {
                movementStrategy = new DiagonalMovementStrategy();
            } else {
                movementStrategy = new VerticalMovementStrategy();
            }
            MonsterController monsterController = monsterControllerFactory.createMonsterController(monster, movementStrategy);
            this.monsterControllers.add(monsterController);
        }
    }
    public void toDo(String keyPressed){
        if(!Objects.equals(keyPressed, null)){
            playerController.toDo(keyPressed);
        }
        bulletsController.toDo(keyPressed); // Nao espera por nenhum keyboard input
        for (MonsterController monsterController : monsterControllers) {
            monsterController.toDo(null);
        }
    }
}
