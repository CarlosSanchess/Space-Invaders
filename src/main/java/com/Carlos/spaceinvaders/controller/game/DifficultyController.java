package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.model.models.ScoreModel;

public class DifficultyController extends Controller<MonsterFactoryModel> {

    private ScoreModel scoreModel;
    DifficultyController(MonsterFactoryModel monsterFactoryModel, ScoreModel scoreModel){
        super(monsterFactoryModel);
        this.scoreModel = scoreModel;
    }

    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        int score = scoreModel.getScore();
        if (score % 75 == 0 && score != 0) {
            super.getModel().setNumMonstros(super.getModel().getNumMonstros() + 1);
        }
        if (score % 20 == 0 && score != 0) {
            int retira = 100 / (1 + score / 1000);
            getModel().setDelay(Math.max(0, getModel().getDelay()) - retira);
        }
    }
}
