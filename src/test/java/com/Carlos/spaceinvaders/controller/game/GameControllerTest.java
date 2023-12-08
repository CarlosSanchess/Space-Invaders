package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.ResumeMenuState;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameControllerTest {
    private GameController gameController;
    private ArenaModel arenaModel;
    private Game game;

    @BeforeEach
    public void setUp() {
        arenaModel = mock(ArenaModel.class);
        game = mock(Game.class);
        gameController = new GameController(arenaModel);

    }

    @Test
    public void testConstructor() {
        assertNotNull(gameController);
    }

    @Test
    public void testToDoEscapeKey() {
        String keyPressed = "Escape";
        long time = System.currentTimeMillis();

        gameController.toDo(game, keyPressed, time);

        verify(game).pushState(any(ResumeMenuState.class));
    }

    @Test
    public void testToDoQuitKey() {
        String keyPressed = "Quit";
        long time = System.currentTimeMillis();

        gameController.toDo(game, keyPressed, time);

        verify(game).pushState(any(ResumeMenuState.class));
    }

    @Test
    public void testToDoOtherKey() {
        String keyPressed = "Other";
        long time = System.currentTimeMillis();

        gameController.toDo(game, keyPressed, time);

        verify(game, never()).pushState(any(ResumeMenuState.class));
    }
}