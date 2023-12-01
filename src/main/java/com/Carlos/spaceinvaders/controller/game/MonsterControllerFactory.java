package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterModel;

import java.util.Random;

public class MonsterControllerFactory {
    private MovementStrategy movementStrategy;

    public MonsterControllerFactory() {
    }

    public MonsterController createMonsterController(MonsterModel monster) {
        MovementStrategy movementStrategy = getRandomMovementStrategy();
        return new MonsterController(monster, movementStrategy);
    }

    private MovementStrategy getRandomMovementStrategy() {
        Random random = new Random();
        int randomNumber = random.nextInt(11);
        if (randomNumber < 2) {
            return new ShooterMovementStrategy();
        } else if (randomNumber < 4) {
            return new DiagonalMovementStrategy();
        } else {
            return new VerticalMovementStrategy();
        }
    }
}
