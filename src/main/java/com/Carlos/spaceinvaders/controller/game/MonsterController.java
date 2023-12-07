package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.MovementStrategy;
import com.Carlos.spaceinvaders.model.models.MonsterModel;

public class MonsterController extends Controller<MonsterModel> {

    private MovementStrategy movementStrategy;
    private long lastMove;
    public MonsterController(MonsterModel model,MovementStrategy movementStrategy) {
        super(model);
        this.movementStrategy = movementStrategy;
        this.lastMove = 0;
    }
    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        if(Time - lastMove > 1000){
            //System.out.println(lastMove);
            //System.out.println(Time);
            movementStrategy.move(getModel());
            //System.out.println("dasda");
            this.lastMove = Time;
        }

    }
}
