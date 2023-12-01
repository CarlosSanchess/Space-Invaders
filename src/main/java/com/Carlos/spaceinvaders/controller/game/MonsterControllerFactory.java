package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterModel;

public class MonsterControllerFactory {
    private MovementStrategy movementStrategy;

    public MonsterControllerFactory(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public MonsterController createMonsterController(MonsterModel monster,MovementStrategy movementStrategy) {
        return new MonsterController(monster, movementStrategy);
    }
}
