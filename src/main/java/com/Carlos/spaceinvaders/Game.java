package com.Carlos.spaceinvaders;

import com.Carlos.spaceinvaders.controller.game.GameController;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.builders.FPS;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.game.DrawGame;


import java.awt.*;
import java.io.IOException;
import java.util.Objects;


public class Game {

    private final LanternaGui GUI;

    ArenaModel  arena = new ArenaModel(getScreenSize().getX() / 25,getScreenSize().getY() / 25); // Valor Fixo?Perguntar ao Professor.
    //ArenaModel  arena = new ArenaModel(80,30);

    private final DrawGame drawGame = new DrawGame(this.arena);
    private final GameController gameController = new GameController(this.arena);


    Game() throws IOException, FontFormatException {
        this.GUI = new LanternaGui(getScreenSize().getX() / 25,getScreenSize().getY() / 25); // Numero de pixeis do pc/ numero de pixeis do char

    }


    public void run() throws IOException, InterruptedException {
        String Key;
        while(true) {
            Key = GUI.getUserInput();
            System.out.println(arena.getPlayer().getPosition().getX());
            drawGame.lanternaDraw(GUI);
            if(Objects.equals(Key, "ArrowLeft"))
                System.out.println(Key);
                gameController.toDo(Key);
            Thread.sleep(FPS.getFps(40));
        }

    }
    public PositionModel getScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new PositionModel(screenSize.width, screenSize.height);
    }
}