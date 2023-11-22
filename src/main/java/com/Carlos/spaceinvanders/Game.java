package com.Carlos.spaceinvanders;

import com.Carlos.spaceinvanders.Entities.arenaModel;
import com.Carlos.spaceinvanders.Entities.Builders.FPS;
import com.Carlos.spaceinvanders.UI.drawArena;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import com.Carlos.spaceinvanders.Controls.arenaControl;





import java.io.IOException;



public class Game {
    private Screen screen;
    private TextGraphics graphics;
    private int sizeX = 80;
    private int sizeY = 30;
    private drawArena drawArena;
    private arenaControl arenaControl;


     arenaModel arena = new arenaModel(sizeX,sizeY);
    Game(Screen screen) throws IOException, InterruptedException { //Melhor pratica que try catch
        this.screen = screen;
        this.screen.setCursorPosition(null); // we don't nenulled a cursor
        this.screen.startScreen(); // screens must be started
        this.screen.doResizeIfNecessary(); // resize screen if necessary

        graphics = screen.newTextGraphics();
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
        screen.clear();
        drawArena = arena.getDrawArena(); //Obtem a arena
        drawArena.draw(graphics);
        screen.refresh();
    }

}