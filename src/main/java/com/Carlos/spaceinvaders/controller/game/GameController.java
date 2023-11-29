package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

import javax.swing.*;
import java.security.Key;

public class GameController extends Controller<ArenaModel> {
    PlayerModel playerModel;
    PlayerController playerController;
    public GameController(ArenaModel arenaModel){
        super(arenaModel);
        //this.playerModel = super.getModel().getPlayer();
        this.playerController = new PlayerController(super.getModel().getPlayer(),super.getModel().getWidth());
    }
    public void toDo(String keyPressed){
        playerController.toDo(keyPressed);
    }

    protected boolean canMove(PositionModel position){ //TODO so se aplica ao player atualmente
        int arenaWidth = super.getModel().getWidth();
        return position.getX() < arenaWidth - 1 && position.getX() > 1;
    }
}
