package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterModel;

import java.util.Random;

public class MonsterControllerFactory {
    private MovementStrategy movementStrategy;
    private int arenaW;

    public MonsterControllerFactory(int arenaW) {
        this.arenaW = arenaW;
    }

    public MonsterController createMonsterController(MonsterModel monster) {
        MovementStrategy movementStrategy = getRandomMovementStrategy();
        return new MonsterController(monster,arenaW, movementStrategy);
    }

    private MovementStrategy getRandomMovementStrategy() {
        Random random = new Random();
        int randomNumber = random.nextInt(11);
        if (randomNumber < 2) {
            return new ShooterMovementStrategy(arenaW);
        } else if (randomNumber < 4) {
            return new DiagonalMovementStrategy(arenaW);
        } else {
            return new VerticalMovementStrategy();
        }
    }
}
