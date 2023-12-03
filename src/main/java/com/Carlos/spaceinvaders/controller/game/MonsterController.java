package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.MovementStrategy;
import com.Carlos.spaceinvaders.model.models.MonsterModel;

public class MonsterController extends Controller<MonsterModel> {

    private MovementStrategy movementStrategy;
    private int arenaW;
    private long lastMove;
    public MonsterController(MonsterModel model, int arenaW ,MovementStrategy movementStrategy) {
        super(model);
        this.arenaW = arenaW;
        this.movementStrategy = movementStrategy;
    }
    @Override
    public void toDo(String keyPressed, long Time) {
        if(Time - lastMove > 1000){
            movementStrategy.move(getModel());
            this.lastMove = Time;
        }

    }
}
