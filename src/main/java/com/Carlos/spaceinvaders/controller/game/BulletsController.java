package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.*;
import com.Carlos.spaceinvaders.model.models.PowerUp;

import java.util.List;

public class BulletsController extends Controller<List<BulletModel>> {

    private List<MonsterModel> activeMonsters;
    private List<PowerUp> activePowerUps;
    private PlayerModel playerModel;
    private ScoreModel scoreModel;
    private long lastScoreBoostTime;
    private long upTime;
    public BulletsController(List<BulletModel> bullets, List<MonsterModel> activeMonsters, List<PowerUp> activePowerUps, PlayerModel playerModel, ScoreModel scoreModel){
        super(bullets);
        this.activeMonsters = activeMonsters;
        this.activePowerUps = activePowerUps;
        this.playerModel = playerModel;
        this.scoreModel = scoreModel;
        this.lastScoreBoostTime = 0;
        this.upTime = 10000;
    }
    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        for(BulletModel bullet : getModel()){
                move(bullet, Time);
        }
        if(lastScoreBoostTime != 0 && Time - lastScoreBoostTime > upTime){
            playerModel.setPowerUpType(null);
            lastScoreBoostTime = 0;
        }
    }

    public void move(BulletModel bullet,long Time) {
        PositionModel newPosition = calculateNewPosition(bullet); //Cria a posição futura da bala, evita que haja repitição de código.
        boolean colidiu = colide(newPosition, Time);
        if(colidiu) {
            bullet.setActive(false);
        }else{
            bullet.getPosition().setY(newPosition.getY());
        }
        bullet.isActive();
    }
    private PositionModel calculateNewPosition(BulletModel bullet) {
        int newY = bullet.getDirection() ? bullet.getPosition().getY() - bullet.getSpeed() : bullet.getPosition().getY() + bullet.getSpeed();
        return new PositionModel(bullet.getPosition().getX(), newY);
    }

    private boolean colide(PositionModel nextPosition, long Time){ // Passar um controller?
        MonsterModel monster = isMonster(nextPosition);
        PowerUp powerUp = isPowerUp(nextPosition);
        boolean playerhit = isPlayer(nextPosition);
        if(monster != null){
            activeMonsters.remove(monster);
            this.scoreModel.incrementScore();
            return true;
        }
        if(powerUp != null){
            processPowerUp(powerUp,Time);
            activePowerUps.remove(powerUp);
        }
        return playerhit;
    }
    private MonsterModel isMonster(PositionModel nextPosition){     //Usar uma função génerica??
        for(MonsterModel monster : activeMonsters){
            if(monster.getPosition().equals(nextPosition)){
                return monster;
            }
        }
        return null;
    }
    private boolean isPlayer(PositionModel nextPosition){
        if(playerModel.getPosition().equals(nextPosition) || playerModel.getPosition().getLeftBound().equals(nextPosition) || playerModel.getPosition().getRightBound().equals(nextPosition)){
            playerModel.decrementHitPoints();
            return true;
        }
        return false;
    }
    private PowerUp isPowerUp(PositionModel newPosition) {
        for (PowerUp powerUp : activePowerUps) {
            if (newPosition.equals(powerUp.getPosition())) {
                return powerUp;
            }
        }
        return null;
    }
    private void processPowerUp(PowerUp powerUp, long Time){
        if(powerUp.getPowerUpType() == PowerUp.PowerUpType.HealthBoost) HealthBoost();
        if(powerUp.getPowerUpType() == PowerUp.PowerUpType.ScoreBoost){
            ScoreBoost();
            lastScoreBoostTime = Time;
        }

        powerUp.incrementActive();
    }
    private void ScoreBoost(){
        scoreModel.setIncrementValue(5); // Permanente, Tornar posível reverter passado X segundos.
        playerModel.setPowerUpType(PowerUp.PowerUpType.ScoreBoost);
    }
    private void HealthBoost(){
        if(playerModel.getHitPoints() < 3){
            playerModel.incrementHitPoints();
        }
    }
}
