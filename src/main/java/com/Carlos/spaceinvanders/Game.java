package com.Carlos.spaceinvanders;

import com.Carlos.spaceinvanders.Entities.Model.ArenaModel;
import com.Carlos.spaceinvanders.Entities.Builders.FPS;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.DrawArena;

import java.io.IOException;

public class Game {

    private DrawArena drawArena;

    private final LanternaGui GUI;

    ArenaModel arena = new ArenaModel(80,30);
    Game() throws IOException, InterruptedException { //Melhor pratica que try catch
        this.GUI = new LanternaGui(80,30);

    }


    public void run() throws IOException, InterruptedException {
        //Process aqui
        //Faz sentido ter um screen.pollInput aqui
        while(true) {
           drawGame();
           Thread.sleep(FPS.getFps(40)); // 40 FRAMES PER SECOND //Fix no movimento continuo da nave fazer com que haja um limite de speed da nave
        }

    }


    public void drawGame() throws  IOException{
        GUI.screenClear();
        drawArena = arena.getDrawArena(); //Obtem a arena
        drawArena.draw(GUI.getGraphics());
        GUI.screenRefresh();
    }

}