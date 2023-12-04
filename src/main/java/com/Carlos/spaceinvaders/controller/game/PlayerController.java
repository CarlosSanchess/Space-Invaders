package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class PlayerController extends Controller<PlayerModel> {

    int arenaW;
    List<BulletModel> bullets;
    private long lastShoot;

    public PlayerController(PlayerModel player, int arenaW, List<BulletModel> bullets){  //TODO Não há maneira melhor de fazer isto-?
        super(player);
        this.arenaW = arenaW;
        this.bullets = bullets;
        this.lastShoot = 0;
    }


    public void moveLeft(){
            move(-1);
    }
    public void moveRight(){
            move(1);
    }
    private void move(int direction) {
        int actualX = getModel().getPosition().getX();
        if(canMove(direction + actualX))
             getModel().getPosition().setX(direction + actualX);
    }
    private boolean canMove(int wantedX){return wantedX < arenaW - 3 && wantedX > 2;} //mudei de return wantedX < arenaW - 1 && wantedX > 0;
    public void shoot(long Time){
        if(Time - lastShoot > getModel().getDelayShooting()){
            bullets.add(novaBala());
            this.lastShoot = Time;
        }

    }
    public BulletModel novaBala(){
        PositionModel playerPosition = getModel().getPosition();

        return new BulletModel( new PositionModel(playerPosition.getX() , playerPosition.getY() - 2),1, true) ; //Added -2 because of the spaceship
    }


    @Override
    public void toDo(Game game, String keyPressed, long Time){
        if(Objects.equals(keyPressed, "ArrowLeft")) moveLeft();
        if(Objects.equals(keyPressed,"ArrowRight")) moveRight();
        if(Objects.equals(keyPressed,"Space") || Objects.equals(keyPressed,"ArrowUp")) shoot(Time);
    }

}
