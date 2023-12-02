package com.Carlos.spaceinvaders;

import com.Carlos.spaceinvaders.controller.game.GameController;
import com.Carlos.spaceinvaders.controller.game.MonsterControllerFactory;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.builders.FPS;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.game.DrawGame;

import java.awt.*;
import java.io.IOException;

public class Game {
    private final LanternaGui gui;
    private final ArenaModel arena;
    private final DrawGame drawGame;
    private final GameController gameController;
    private String key;

    public Game() throws IOException, FontFormatException {
        PositionModel screenSize = getScreenSize();
        this.gui = new LanternaGui(screenSize.getX() / 25, screenSize.getY() / 25);
        this.arena = new ArenaModel(screenSize.getX() / 25, screenSize.getY() / 25);
        MonsterControllerFactory monsterControllerFactory = new MonsterControllerFactory(arena.getWidth());
        this.gameController = new GameController(this.arena, monsterControllerFactory);
        this.drawGame = new DrawGame(this.arena);
    }

    public void run() throws IOException, InterruptedException {
        while (true) {
            key = gui.getUserInput();
            drawGame.lanternaDraw(gui);
            gameController.toDo(key);
            Thread.sleep(FPS.getFps(10));
        }
    }

    private PositionModel getScreenSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new PositionModel(screenSize.width, screenSize.height);
    }
}