package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.model.models.OptionsModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OptionsControllerTest {

    @Mock
    private Game game;

    private OptionsModel optionsModel;
    private OptionsController optionsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        optionsModel = new OptionsModel();
        optionsController = new OptionsController(optionsModel);
    }

    @Test
    public void testToDo_EnterKey_GamePushState() {
        String keyPressed = "Enter";
        optionsController.toDo(game, keyPressed, 0L);
        verify(game).pushState(any(MenuState.class));
    }

    @Test
    public void testToDo_EscapeKey_GamePopState() {
        String keyPressed = "Escape";
        optionsController.toDo(game, keyPressed, 0L);
        verify(game).popState();
    }

    @Test
    public void testToDo_QuitKey_GamePopState() {
        String keyPressed = "Quit";
        optionsController.toDo(game, keyPressed, 0L);
        verify(game).popState();
    }

    @Test
    public void testToDo_NullKey_NoAction() {
        optionsController.toDo(game, null, 0L);
        verifyNoInteractions(game);
    }

    @Test
    public void testToDo_OtherKey_NoAction() {
        String keyPressed = "OtherKey";
        optionsController.toDo(game, keyPressed, 0L);
        verifyNoInteractions(game);
    }

    @Test
    public void testConstructor() {
        assertEquals(optionsModel, optionsController.getModel());
    }
}