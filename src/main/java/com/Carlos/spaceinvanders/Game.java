package com.Carlos.spaceinvanders;

import com.Carlos.spaceinvanders.Models.Model.ArenaModel;
import com.Carlos.spaceinvanders.Models.Builders.FPS;
import com.Carlos.spaceinvanders.Models.Model.PositionModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;


import java.awt.*;
import java.io.IOException;

//TODO
//Check se o codigo esta blindado do GUI
//Aplicar o GUI ao Menu ou seja cria duas Screens diferentes


import com.Carlos.spaceinvanders.UI.View.Game.DrawGame;

public class Game {



    private final int xInicial;
    private final int yInicial;
    private final LanternaGui GUI;

    ArenaModel  arena = new ArenaModel(getScreenSize().getX() / 25,getScreenSize().getY() / 25); // Numero de pixeis do pc/ numero de pixeis do char
    //ArenaModel  arena = new ArenaModel(80,30); // Numero de pixeis do pc/ numero de pixeis do char

    private final DrawGame drawGame = new DrawGame(arena);
    Game() throws IOException, InterruptedException, FontFormatException {
        this.xInicial = getScreenSize().getX() / 25;
        this.yInicial = getScreenSize().getY() / 25;
        this.GUI = new LanternaGui(xInicial,yInicial);

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