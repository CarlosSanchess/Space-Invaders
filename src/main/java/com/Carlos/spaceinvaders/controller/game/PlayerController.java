package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

import java.awt.*;
import java.util.Objects;

public class PlayerController extends Controller<PlayerModel> {


    public PlayerController(PlayerModel player){
        super(player);
    }


    public void moveLeft(){
            int x = super.getModel().getPosition().getX();
            super.getModel().getPosition().setX(x - 1);
    }
    public void moveRight(){
            int x = super.getModel().getPosition().getX();
            super.getModel().getPosition().setX(x + 1);
    }
    public void shoot(){

    }

    @Override
    public void toDo( String keyPressed){
        if(Objects.equals(keyPressed, "ArrowLeft")) moveLeft();
        if(Objects.equals(keyPressed,"ArrowRight")) moveRight();
    }
}
