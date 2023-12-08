package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.model.models.GameOverMenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameOverMenuControllerTest {
    private GameOverMenuController controller;

    @BeforeEach
    void setUp() {
        controller = new GameOverMenuController(new GameOverMenuModel());
    }

    @Test
    void testNextEntry() {
        controller.nextEntry();
        assertEquals(1, controller.getModel().getEntry());
    }

    @Test
    void testPreviousEntry() {
        controller.previousEntry();
        assertEquals(controller.getModel().getEntriesSize() - 1, controller.getModel().getEntry());
    }

    @Test
    void testToDoArrowDown() throws IOException, FontFormatException {
        Game game = new Game();
        controller.toDo(game, "ArrowDown", 0);
        assertEquals(1, controller.getModel().getEntry());
    }

    @Test
    void testToDoArrowUp() throws IOException, FontFormatException {
        Game game = new Game();
        controller.toDo(game, "ArrowUp", 0);
        assertEquals(controller.getModel().getEntriesSize() - 1, controller.getModel().getEntry());
    }
}