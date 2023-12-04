package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.*;
import com.Carlos.spaceinvaders.view.Viewer;

import java.util.List;

public class BulletsController extends Controller<List<BulletModel>> {

    private List<MonsterModel> activeMonsters;
    private PlayerModel playerModel;
    private ScoreModel scoreModel;
    public BulletsController(List<BulletModel> bullets, List<MonsterModel> activeMonsters, PlayerModel playerModel, ScoreModel scoreModel){
        super(bullets);
        this.activeMonsters = activeMonsters;
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
        colide(newPosition);

        bullet.getPosition().setY(newPosition.getY());
        bullet.isActive();
    }
    private PositionModel calculateNewPosition(BulletModel bullet) {
        int newY = bullet.getDirection() ? bullet.getPosition().getY() - bullet.getSpeed() : bullet.getPosition().getY() + bullet.getSpeed();
        return new PositionModel(bullet.getPosition().getX(), newY);
    }

    private void colide(PositionModel nextPosition){
        MonsterModel monster = isMonster(nextPosition);
        if(monster != null){
            activeMonsters.remove(monster);
            this.scoreModel.incrementScore();
        }
        isPlayer(nextPosition);
    }
    private MonsterModel isMonster(PositionModel nextPosition){     //Usar uma função génerica??
        for(MonsterModel monster : activeMonsters){
            if(monster.getPosition().equals(nextPosition)){
                return monster;
            }
        }
        return null;
    }
    private void isPlayer(PositionModel nextPosition){
        if(playerModel.getPosition().equals(nextPosition) || playerModel.getPosition().getLeftBound().equals(nextPosition) || playerModel.getPosition().getRightBound().equals(nextPosition)){
            playerModel.decrementHitPoints();
        }
    }
}
