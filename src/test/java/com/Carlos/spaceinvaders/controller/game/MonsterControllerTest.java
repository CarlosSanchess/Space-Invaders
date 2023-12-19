package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.MovementStrategy;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

class MonsterControllerTest {

    private MonsterModel model;
    private MovementStrategy movementStrategy;
    private MonsterController monsterController;

    @BeforeEach
    void setUp() {
        model = mock(MonsterModel.class);
        movementStrategy = mock(MovementStrategy.class);
        monsterController = new MonsterController(model, movementStrategy,3,null);
    }
    @Test
    void toDo_ShouldNotMoveModel_WhenTimeDifferenceIsLessThan1000() {
        Game game = mock(Game.class);
        long currentTime = 500;
        monsterController.toDo(game, "keyPressed", currentTime);

        verifyNoInteractions(movementStrategy);
        assertNotEquals(currentTime, monsterController.getLastMove());
    }
    @Test
    void getLastMoveShouldReturnLastMoveValue() {
        assertEquals(0, monsterController.getLastMove());
    }
    /*
    @Test
    void toDo_ShouldMoveModel_WhenTimeDifferenceIsGreaterThan1000() {
        Game game = mock(Game.class);
        long currentTime = System.currentTimeMillis();
        monsterController.toDo(game, null, currentTime);

        verify(movementStrategy, times(1)).move(model);
        assertEquals(currentTime, monsterController.getLastMove());
    }
     */

}