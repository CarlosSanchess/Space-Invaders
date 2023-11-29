package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

import java.awt.*;
import java.util.Objects;

public class PlayerController extends Controller<PlayerModel> {

    int arenaW;
    public PlayerController(PlayerModel player, int arenaW){  //TODO Não há maneira melhor de fazer isto-?
        super(player);
        this.arenaW = arenaW;
    }


    public void moveLeft(){
            move(-1);
    }
    public void moveRight(){
            move(1);
    }
    private void move(int direction) {
        int actualX = super.getModel().getPosition().getX();
        if(canMove(direction + actualX))
             super.getModel().getPosition().setX(direction + actualX);
    }
    private boolean canMove(int wantedX){ //TODO so se aplica ao player atualmente
        return wantedX < arenaW - 1 && wantedX > 0;
    }
    public void shoot(){

    }

    @Override
    public void toDo( String keyPressed){
        if(Objects.equals(keyPressed, "ArrowLeft")) moveLeft();
        if(Objects.equals(keyPressed,"ArrowRight")) moveRight();

    }
}
