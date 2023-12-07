package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.model.models.ScoreModel;

public class DifficultyController extends Controller<MonsterFactoryModel> { // Neste controller vamos manipular o delay da criação dos monstros, a quantidade criada, consoante o numero do score.

    private long delay;
    private int numMonstros;
    private ScoreModel scoreModel;
    DifficultyController(MonsterFactoryModel monsterFactoryModel, ScoreModel scoreModel){
        super(monsterFactoryModel);
        this.delay = getModel().getDelay();
        this.numMonstros = getModel().getNumMonstros();
        this.scoreModel = scoreModel;
    }

    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        int score = scoreModel.getScore();
        if (score % 75 == 0 && score != 0) {
            numMonstros++;
        }
        if (score % 20 == 0 && score != 0) {
            int retira = 100 / (1 + score / 1000); //Faz com que em scores altos, o delay nao seja tao grande, fazendo com que o jogo possa ir a scores altos.
            delay = Math.max(0, delay - retira);
        }
    }
}
