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
    public BulletsController(List<BulletModel> bullets, List<MonsterModel> activeMonsters, List<PowerUp> activePowerUps, PlayerModel playerModel, ScoreModel scoreModel){
        super(bullets);
        this.activeMonsters = activeMonsters;
        this.activePowerUps = activePowerUps;
        this.playerModel = playerModel;
        this.scoreModel = scoreModel;
    }
    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        for(BulletModel bullet : getModel()){
                move(bullet);
        }
    }

    public void move(BulletModel bullet) {
        PositionModel newPosition = calculateNewPosition(bullet); //Cria a posição futura da bala, evita que haja repitição de código.
        boolean colidiu = colide(newPosition);
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

    private boolean colide(PositionModel nextPosition){
        MonsterModel monster = isMonster(nextPosition);
        PowerUp powerUp = isPowerUp(nextPosition);
        boolean playerhit = isPlayer(nextPosition);
        if(monster != null){
            activeMonsters.remove(monster);
            this.scoreModel.incrementScore();
            return true;
        }
        if(powerUp != null){
            powerUp.setActive(true);
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
    private PowerUp isPowerUp(PositionModel newPosition) {
        for (PowerUp powerUp : activePowerUps) {
            if (newPosition.equals(powerUp.getPosition())) {
                return powerUp;
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
}
