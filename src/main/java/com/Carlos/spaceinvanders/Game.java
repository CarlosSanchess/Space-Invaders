package com.Carlos.spaceinvanders;

import com.Carlos.spaceinvanders.Entities.Model.ArenaModel;
import com.Carlos.spaceinvanders.Entities.Builders.FPS;
import com.Carlos.spaceinvanders.GUI.LanternaGui;


import java.awt.*;
import java.io.IOException;

//TODO
//Check se o codigo esta blindado do GUI
//Aplicar o GUI ao Menu ou seja cria duas Screens diferentes


import com.Carlos.spaceinvanders.UI.View.Game.DrawGame;

public class Game {



    private final LanternaGui GUI;

    ArenaModel arena = new ArenaModel(80,30);
    private final DrawGame drawGame = new DrawGame(arena);
    Game() throws IOException, InterruptedException, FontFormatException {
        this.GUI = new LanternaGui(80,30);
    }


    public void run() throws IOException, InterruptedException {
        while(true) {
            drawGame.lanternaDraw(GUI);
            Thread.sleep(FPS.getFps(40));
        }

    }
}