package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.MenuModel;
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
    public void toDo(Game game,String keyPressed, long Time){
        if (keyPressed != null && keyPressed.equals("Escape")) {
            game.popState();
            return;
        }
        playerController.toDo(game,keyPressed,Time);
        bulletsController.toDo(game,keyPressed,Time); // Nao espera por nenhum keyboard input
        for (MonsterController monsterController : monsterControllers) {
            monsterController.toDo(game,null,Time);
        }
    }
}