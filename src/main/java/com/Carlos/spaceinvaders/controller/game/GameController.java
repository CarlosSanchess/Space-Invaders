package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;

import javax.swing.*;
import java.security.Key;

public class GameController extends Controller<ArenaModel> {
    PlayerModel playerModel;
    PlayerController playerController;
    public GameController(ArenaModel arenaModel){
        super(arenaModel);
        //this.playerModel = super.getModel().getPlayer();
        this.playerController = new PlayerController(super.getModel().getPlayer());
    }
    public void toDo(String keyPressed){
        //playerController = new PlayerController(this.playerModel);
        playerController.toDo(keyPressed);
    }

}
