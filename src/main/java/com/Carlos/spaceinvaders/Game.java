package com.Carlos.spaceinvaders;

import com.Carlos.spaceinvaders.State.GameState;
import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.State.State;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.builders.FPS;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;


import java.awt.*;
import java.io.IOException;

public class Game {

    private final LanternaGui GUI;
    private State state;

    String Key;

    Game() throws IOException, FontFormatException {
        this.GUI = new LanternaGui(getScreenSize().getX() / 25,getScreenSize().getY() / 25); // Numero de pixeis do pc/ numero de pixeis do char
        //this.state = new GameState(new ArenaModel(getScreenSize().getX() / 25,getScreenSize().getY() / 25)); //Valor Fixo?
        this.state = new MenuState(new MenuModel());
    }


    public void run() throws IOException, InterruptedException {

        int FPS = 50;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();
            Key = GUI.getUserInput();
            state.step(Key, GUI, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
    }
    public PositionModel getScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new PositionModel(screenSize.width, screenSize.height);
    }
}