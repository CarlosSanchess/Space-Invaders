package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.MonsterModel;

public class MonsterController extends Controller<MonsterModel> {

    private MovementStrategy movementStrategy;
    private int arenaW;

    public MonsterController(MonsterModel model, int arenaW ,MovementStrategy movementStrategy) {
        super(model);
        this.arenaW = arenaW;
        this.movementStrategy = movementStrategy;
    }
    @Override
    public void toDo(String keyPressed) {
        movementStrategy.move(getModel());
    }
}
