package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;




public class ScoreTest {

    private ScoreModel scoreModel;

    @BeforeEach
    public void setUp() {
        PositionModel position = new PositionModel(0, 0);
        scoreModel = new ScoreModel(position);
    }

    @Test
    public void testGetScore() {
        int expectedScore = 0;
        int actualScore = scoreModel.getScore();
        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testSetScore() {
        int expectedScore = 100;
        scoreModel.setScore(expectedScore);
        int actualScore = scoreModel.getScore();
        assertEquals(expectedScore, actualScore);
    }
}
