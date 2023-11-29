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
            move(-1);
    }
    public void moveRight(){
            move(1);
    }
    private void move(int X) {
        int x = super.getModel().getPosition().getX();
        super.getModel().getPosition().setX(x + X);
    }
    public void shoot(){

    }

    @Override
    public void toDo( String keyPressed){
        if(Objects.equals(keyPressed, "ArrowLeft")) moveLeft();
        if(Objects.equals(keyPressed,"ArrowRight")) moveRight();
    }
}
