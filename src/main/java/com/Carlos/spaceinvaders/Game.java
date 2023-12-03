package com.Carlos.spaceinvaders;

import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.State.State;
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
        this.state = new MenuState(new MenuModel(),this); //Valor Fixo?
    }
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.run();
        } catch (IOException | InterruptedException | FontFormatException e) {
            e.printStackTrace();
        }
    }
    public void run() throws IOException, InterruptedException {

        int UPS = 50;
        int updateTime = 1000 / UPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();
            Key = GUI.getUserInput();
            state.step(Key, GUI, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = updateTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setState(State state) {
        this.state = state;
    }

    public PositionModel getScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new PositionModel(screenSize.width, screenSize.height);
    }
}