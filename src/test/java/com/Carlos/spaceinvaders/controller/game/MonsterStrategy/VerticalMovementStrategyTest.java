package com.Carlos.spaceinvaders.controller.game.MonsterStrategy;

import com.Carlos.spaceinvaders.controller.game.MonstersStrategy.VerticalMovementStrategy;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class VerticalMovementStrategyTest {

    private VerticalMovementStrategy verticalMovementStrategy;
    private MonsterModel monster;
    private PositionModel positionModel;

    @BeforeEach
    public void setUp() {
        monster = mock(MonsterModel.class);
        positionModel = new PositionModel(5, 5);
        when(monster.getPosition()).thenReturn(positionModel);
        when(monster.getSpeed()).thenReturn(1);
        verticalMovementStrategy = new VerticalMovementStrategy();
    }

    @Test
    public void testMove() {
        verticalMovementStrategy.move(monster);
        verify(monster, times(1)).setPosition(any(PositionModel.class));
    }
}