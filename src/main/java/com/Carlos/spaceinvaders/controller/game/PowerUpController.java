package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PowerUp.PowerUp;

import java.util.List;

public class PowerUpController extends Controller<List<PowerUp>> {

    public enum PowerUpType {
        HealthBoost,
        ScoreBoost
    }

    private PowerUpType powerUpType;
    private ArenaModel arenaModel;
    private long lastMove;
    public PowerUpController(List<PowerUp> activePowerUp){
            super(activePowerUp);
            lastMove = 0;

    }
    private void move(List<PowerUp> activePowerUp) {
        for (PowerUp powerUp : getModel()) {
            int currentY = powerUp.getPosition().getY();
            int newY = currentY + powerUp.getSpeed();
            powerUp.getPosition().setY(newY);
        }
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
        if(Time - lastMove > 1500 && !getModel().isEmpty()){
            move(getModel());

            this.lastMove = Time;
        }
    }
}
