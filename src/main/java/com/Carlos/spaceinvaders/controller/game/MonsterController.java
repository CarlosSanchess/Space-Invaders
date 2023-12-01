package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.MonsterModel;

public class MonsterController extends Controller<MonsterModel> {

    private MovementStrategy movementStrategy;

    public MonsterController(MonsterModel model, MovementStrategy movementStrategy) {
        super(model);
        this.movementStrategy = movementStrategy;
    }

    @Override
    public void toDo(String keyPressed) {
        movementStrategy.move(getModel());
    }
}
