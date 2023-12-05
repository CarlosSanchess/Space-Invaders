package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PowerUp.PowerUp;

public class PowerUpController extends Controller<PowerUp> {

    public enum PowerUpType {
        HealthBoost,
        ScoreBoost
    }

    private PowerUpType powerUpType;
    private ArenaModel arenaModel;
    private long lastMove;
    public PowerUpController(PowerUp PowerUp,ArenaModel arenaModel,PowerUpType powerUpType){
            super(PowerUp);
            this.arenaModel = arenaModel;
            this.powerUpType = powerUpType;
    }
    /*
    private void processPowerUp(PowerUpType powerUpType){
        if(this.powerUpType == powerUpType){
            switch(powerUpType){
                case HealthBoost:
                    HealthBoost();
                    break;
                case ScoreBoost:
                    ScoreBoost();
                    break;
            }
        }
    }
    private void HealthBoost(){
        if(arenaModel.getPlayer().getHitPoints() < 3){
            arenaModel.getPlayer().incrementHitPoints();;
        }
    }
    private void ScoreBoost(){
        arenaModel.getScore().setIncrementValue(5); // Permanente, Tornar posível reverter passado X segundos.
    }

     */
    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        if(Time - lastMove > 1000){
            getModel().move();
            this.lastMove = Time;
        }
    }
}
