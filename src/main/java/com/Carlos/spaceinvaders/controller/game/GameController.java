package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

import javax.swing.*;
import java.security.Key;
import java.util.Objects;

public class GameController extends Controller<ArenaModel> {
    PlayerModel playerModel;
    PlayerController playerController;
    BulletsController bulletsController;
    public GameController(ArenaModel arenaModel){
        super(arenaModel);
        //this.playerModel = super.getModel().getPlayer();
        this.playerController = new PlayerController(super.getModel().getPlayer(),super.getModel().getWidth(), arenaModel.getActiveBullets());
        this.bulletsController = new BulletsController(super.getModel().getActiveBullets());
    }
    public void toDo(String keyPressed){
        if(!Objects.equals(keyPressed, null)){
            playerController.toDo(keyPressed);
        }
        bulletsController.toDo(keyPressed); // Nao espera por nenhum keyboard input
    }


}
