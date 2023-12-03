package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.DiagonalMovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.MovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.ShooterMovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.VerticalMovementStrategy;
import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterControllerFactory {
    private int arenaW;
    private List<BulletModel> bullets;
    private List<MonsterController> monsterControllers;
    public MonsterControllerFactory(int arenaW, List<BulletModel> bullets, List<MonsterModel> activeMonsters) {
        this.arenaW = arenaW;
        this.bullets = bullets;
        this.monsterControllers = new ArrayList<>();
        for (MonsterModel monster : activeMonsters) {
            MonsterController monsterController = createMonsterController(monster);
            this.monsterControllers.add(monsterController);
        }
    }

    public MonsterController createMonsterController(MonsterModel monster) {
        MovementStrategy movementStrategy = getRandomMovementStrategy();
        return new MonsterController(monster, movementStrategy);
    }

    private MovementStrategy getRandomMovementStrategy() {
        Random random = new Random();
        int randomNumber = random.nextInt(11);
        if (randomNumber < 2) {
            return new ShooterMovementStrategy(arenaW, bullets);
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
