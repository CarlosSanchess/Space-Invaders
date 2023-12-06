package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PowerUp;
import java.util.List;


public class PowerUpController extends Controller<List<PowerUp>> {
    //Apenas move os powerUps
    private long lastMove;
    public PowerUpController(List<PowerUp> activePowerUp, ArenaModel arenaModel){
            super(activePowerUp);
            this.lastMove = 0;
    }
    private void move() { //Mudar o nome da função
        for (PowerUp powerUp : getModel()) {
            powerUp.move();
        }
    }


    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        if(Time - lastMove > 1500 && !getModel().isEmpty()){
            move();
            this.lastMove = Time;
        }
    }
}
