package com.Carlos.spaceinvaders;

import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.builders.FPS;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.game.DrawGame;


import java.awt.*;
import java.io.IOException;

//TODO
//Check se o codigo esta blindado do GUI
//Aplicar o GUI ao Menu ou seja cria duas Screens diferentes

public class Game {

    private final LanternaGui GUI;

    ArenaModel  arena = new ArenaModel(getScreenSize().getX() / 25,getScreenSize().getY() / 25); // Valor Fixo?
    //ArenaModel  arena = new ArenaModel(80,30); // Numero de pixeis do pc/ numero de pixeis do char

    private final DrawGame drawGame = new DrawGame(arena);
    Game() throws IOException, InterruptedException, FontFormatException {
        this.GUI = new LanternaGui(getScreenSize().getX() / 25,getScreenSize().getY() / 25);

    }


    public void run() throws IOException, InterruptedException {
        while(true) {
            drawGame.lanternaDraw(GUI);
            Thread.sleep(FPS.getFps(40));
        }

    }
    public PositionModel getScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new PositionModel(screenSize.width, screenSize.height);
    }
}