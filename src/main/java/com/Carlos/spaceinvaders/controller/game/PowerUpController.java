package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PowerUp;
import com.Carlos.spaceinvaders.model.models.PowerUp.PowerUpType;
import java.util.List;

public class PowerUpController extends Controller<List<PowerUp>> {



    private ArenaModel arenaModel;
    private long lastMove;
    public PowerUpController(List<PowerUp> activePowerUp, ArenaModel arenaModel){
            super(activePowerUp);
            lastMove = 0;
            this.arenaModel = arenaModel;

    }
    private void move(List<PowerUp> activePowerUp) { //Mudar o nome da função
        for (PowerUp powerUp : getModel()) {
            powerUp.move();
            if(powerUp.isActive())
                processPowerUp(powerUp.getPowerUpType());
        }
    }

    private void processPowerUp(PowerUpType powerUpType){
        switch(powerUpType){
            case HealthBoost:
                HealthBoost();
                break;
            case ScoreBoost:
                ScoreBoost();
                break;
        }
    }
    private void HealthBoost(){
        if(arenaModel.getPlayer().getHitPoints() < 3){
            arenaModel.getPlayer().incrementHitPoints();
            //arenaModel.getPlayer().setPowerUpType(PowerUpType.HealthBoost);
        }
    }
    private void ScoreBoost(){
        arenaModel.getScore().setIncrementValue(5); // Permanente, Tornar posível reverter passado X segundos.
        arenaModel.getPlayer().setPowerUpType(PowerUpType.ScoreBoost);
    }


    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        if(Time - lastMove > 1500 && !getModel().isEmpty()){
            move(getModel());

            this.lastMove = Time;
        }
    }
}
