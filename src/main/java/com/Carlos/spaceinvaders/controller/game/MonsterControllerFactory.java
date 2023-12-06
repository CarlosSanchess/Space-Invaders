package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.DiagonalMovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.MovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.ShooterMovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.VerticalMovementStrategy;
import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterControllerFactory {
    private int arenaW;
    private List<BulletModel> bullets;
    private List<MonsterController> monsterControllers;
    private List<MonsterModel> activeMonsters;
    private MonsterFactory monsterFactory;

    public MonsterControllerFactory(int arenaW, List<BulletModel> bullets, List<MonsterModel> activeMonsters) {
        this.arenaW = arenaW;
        this.bullets = bullets;
        this.monsterControllers = new ArrayList<>();
        this.activeMonsters = activeMonsters;
        this.monsterFactory = new MonsterFactory(activeMonsters);
    }

    private MonsterController createMonsterController(MonsterModel monster) {

        MovementStrategy movementStrategy = getRandomMovementStrategy();
        return new MonsterController(monster, movementStrategy);
    }

    public void CreateMonstersAndControllers(long Time){
        MonsterModel newMonster = monsterFactory.createMonster(Time,arenaW);
        if(newMonster != null){
            MonsterController monsterController = createMonsterController(newMonster);
            this.monsterControllers.add(monsterController);
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

}
