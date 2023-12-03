package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.DiagonalMovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.MovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.ShooterMovementStrategy;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.VerticalMovementStrategy;
import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;

import java.util.List;
import java.util.Random;

public class MonsterControllerFactory {
    private MovementStrategy movementStrategy;
    private int arenaW;
    List<BulletModel> bullets;
    public MonsterControllerFactory(int arenaW, List<BulletModel> bullets) {
        this.arenaW = arenaW;
        this.bullets = bullets;
    }

    public MonsterController createMonsterController(MonsterModel monster) {
        MovementStrategy movementStrategy = getRandomMovementStrategy();
        return new MonsterController(monster,arenaW, movementStrategy);
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
}
