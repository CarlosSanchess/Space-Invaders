package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.ScoreModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifficultyControllerTest {

    private DifficultyController difficultyController;
    private MonsterFactoryModel monsterFactoryModel;
    private ScoreModel scoreModel;

    @BeforeEach
    public void setUp() {
        monsterFactoryModel = new MonsterFactoryModel();
        scoreModel = new ScoreModel(new PositionModel(10,10));
        difficultyController = new DifficultyController(monsterFactoryModel, scoreModel);
    }

    @Test
    public void testToDo_ScoreMultipleOf75() {
        scoreModel.setScore(75);

        difficultyController.toDo(null, null, 0);

        assertEquals(1, monsterFactoryModel.getNumMonstros());
    }

    @Test
    public void testToDo_ScoreMultipleOf20() {
        scoreModel.setScore(20);
        monsterFactoryModel.setDelay(100);

        difficultyController.toDo(null, null, 0);

        assertEquals(100, monsterFactoryModel.getDelay());
    }

    @Test
    public void testToDo_ScoreNotMultipleOf75Or20() {
        scoreModel.setScore(50);
        monsterFactoryModel.setDelay(100);

        difficultyController.toDo(null, null, 0);

        assertEquals(100, monsterFactoryModel.getDelay());
        assertEquals(1, monsterFactoryModel.getNumMonstros());
    }
}