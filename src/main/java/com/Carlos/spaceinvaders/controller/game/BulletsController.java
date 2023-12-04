package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.Viewer;

import java.util.List;

public class BulletsController extends Controller<List<BulletModel>> {

    private List<MonsterModel> activeMonsters;
    private PlayerModel playerModel;
    public BulletsController(List<BulletModel> bullets, List<MonsterModel> activeMonsters, PlayerModel playerModel){
        super(bullets);
        this.activeMonsters = activeMonsters;
        this.playerModel = playerModel;
    }
    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        for(BulletModel bullet : getModel()){
                move(bullet);
        }
    }

    public void move(BulletModel bullet) {
        if (bullet.getDirection()) {
            colide(new PositionModel(bullet.getPosition().getX(), bullet.getPosition().getY() - bullet.getSpeed())); // Cleaner way?
            bullet.getPosition().setY(bullet.getPosition().getY() - bullet.getSpeed());
        }
        else{
            colide(new PositionModel(bullet.getPosition().getX(),bullet.getPosition().getY() + bullet.getSpeed()));
            bullet.getPosition().setY(bullet.getPosition().getY() + bullet.getSpeed());
        }
        bullet.isActive();
    }

    private void colide(PositionModel nextPosition){
        MonsterModel monster = isMonster(nextPosition);
        if(monster != null){
            activeMonsters.remove(monster);
        }
        isPlayer(nextPosition);
    }
    private MonsterModel isMonster(PositionModel nextPosition){
        for(MonsterModel monster : activeMonsters){
            if(monster.getPosition().equals(nextPosition)){
                return monster;
            }
        }
        return null;
    }
    private void isPlayer(PositionModel nextPosition){
        if(playerModel.getPosition().equals(nextPosition)){
            playerModel.setHitPoints(playerModel.getHitPoints() - 1);
        }
    }
}
