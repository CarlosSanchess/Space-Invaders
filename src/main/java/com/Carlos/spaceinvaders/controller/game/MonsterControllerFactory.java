package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.DiagonalMovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.MovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.ShooterMovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.VerticalMovementStrategy;
import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MonsterControllerFactory {
    private int arenaW;
    private int arenaH;
    private List<BulletModel> bullets;
    private List<MonsterController> monsterControllers;
    private List<MonsterModel> activeMonsters;
    private MonsterFactory monsterFactory;

    public MonsterControllerFactory(int arenaW,int arenaH, List<BulletModel> bullets, List<MonsterModel> activeMonsters, MonsterFactoryModel monsterFactoryModel) {
        this.arenaW = arenaW;
        this.arenaH = arenaH;
        this.bullets = bullets;
        this.monsterControllers = new ArrayList<>();
        this.activeMonsters = activeMonsters;
        this.monsterFactory = new MonsterFactory(monsterFactoryModel,activeMonsters);
    }

    MonsterController createMonsterController(MonsterModel monster) {

        MovementStrategy movementStrategy = getRandomMovementStrategy();
        return new MonsterController(monster, movementStrategy,arenaH, activeMonsters);
    }

    public void CreateMonstersAndControllers(long Time){
        List<MonsterModel> newMonster = monsterFactory.createMonster(Time,arenaW);
        if(newMonster != null){
            for( MonsterModel monster: newMonster){
                MonsterController monsterController = createMonsterController(monster);
                this.monsterControllers.add(monsterController);
            }
        }
    }
    private MovementStrategy getRandomMovementStrategy() {
        Random random = new Random();
        int randomNumber = random.nextInt(11);
        if (randomNumber < 2) {
            return new ShooterMovementStrategy(arenaW, bullets, activeMonsters);
        } else if (randomNumber < 4) {
            return new DiagonalMovementStrategy(arenaW);
        } else {
            return new VerticalMovementStrategy();
        }
    }

    public List<MonsterController> getMonstersControllers(){
     return monsterControllers;
    }

    //private void cleanC
    public boolean checkWinMonster() { //Also Cleans Controllers
        Iterator<MonsterController> iterator = monsterControllers.iterator();

        while (iterator.hasNext()) {
            MonsterController monsterController = iterator.next();
            if(!activeMonsters.contains(monsterController.getMonster()))
                iterator.remove();

            if (monsterController.isWinMonster()) {
                return true;
            }
        }

        return false;
    }
}
