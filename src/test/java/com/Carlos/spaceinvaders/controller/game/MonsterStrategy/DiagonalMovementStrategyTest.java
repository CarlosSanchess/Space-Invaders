package com.Carlos.spaceinvaders.controller.game.MonsterStrategy;

import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.DiagonalMovementStrategy;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class DiagonalMovementStrategyTest {

    private DiagonalMovementStrategy diagonalMovementStrategy;
    private MonsterModel monster;
    private PositionModel positionModel;

    @BeforeEach
    public void setUp() {
        monster = mock(MonsterModel.class);
        positionModel = new PositionModel(5, 5);
        when(monster.getPosition()).thenReturn(positionModel);
        when(monster.getSpeed()).thenReturn(1);
        diagonalMovementStrategy = new DiagonalMovementStrategy(10);
    }

    @Test
    public void testMove_CanMove() {
        diagonalMovementStrategy.move(monster);
        verify(monster, times(1)).setPosition(any(PositionModel.class));
    }
}