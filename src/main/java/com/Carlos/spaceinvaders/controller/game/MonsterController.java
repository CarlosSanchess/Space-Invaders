package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.MovementStrategy;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import java.util.List;

public class MonsterController extends Controller<MonsterModel> {

    private MovementStrategy movementStrategy;
    private int arenaH;
    private long lastMove;
    private boolean winMonster;
    private List<MonsterModel> activeMonsters;
    public MonsterController(MonsterModel model,MovementStrategy movementStrategy, int arenaH, List<MonsterModel> activeMonsters) {
        super(model);
        this.movementStrategy = movementStrategy;
        this.lastMove = 0;
        this.arenaH = arenaH;
        winMonster = false;
        this.activeMonsters = activeMonsters;
    }
    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        if(Time - lastMove > 1000){
            movementStrategy.move(getModel());
            checkWin(getModel());
            this.lastMove = Time;
        }

    }
    private void checkWin(MonsterModel model){
        if(model.getPosition().getY() >=  arenaH - 1 && activeMonsters.contains(model)){
            System.out.println(model.getPosition().getY());
            winMonster = true;
        }
    }

    public boolean isWinMonster() {
        return winMonster;
    }

    public long getLastMove() {
        return lastMove;
    }
}