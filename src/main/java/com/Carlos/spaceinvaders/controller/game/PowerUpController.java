package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PowerUp;
import com.Carlos.spaceinvaders.model.models.PowerUp.PowerUpType;
import java.util.List;

import static com.Carlos.spaceinvaders.model.models.PowerUp.PowerUpType;

public class PowerUpController extends Controller<List<PowerUp>> {



    private ArenaModel arenaModel;
    private long lastMove;
    private long lastScoreBoostTime;
    private long upTime;
    public PowerUpController(List<PowerUp> activePowerUp, ArenaModel arenaModel){
            super(activePowerUp);
            this.lastMove = 0;
            this.arenaModel = arenaModel;
            this.lastScoreBoostTime = 0;
            this.upTime = 15000;

    }
    private void move(long Time) { //Mudar o nome da função
        for (PowerUp powerUp : getModel()) {
            powerUp.move();
            if(powerUp.isActive())
                processPowerUp(powerUp,Time);
        }
    }

    private void processPowerUp(PowerUp powerUp, long Time){
        if(powerUp.getPowerUpType() == PowerUpType.HealthBoost) HealthBoost();
        if(powerUp.getPowerUpType() == PowerUpType.ScoreBoost){
            ScoreBoost();
            lastScoreBoostTime = Time;
        }

        powerUp.setActive(false);
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
        if(lastScoreBoostTime != 0 && Time - lastScoreBoostTime > upTime){
            arenaModel.getPlayer().setPowerUpType(null);
            lastScoreBoostTime = 0;
        }
        if(Time - lastMove > 1500 && !getModel().isEmpty()){
            move(Time);
            this.lastMove = Time;
        }
    }
}
