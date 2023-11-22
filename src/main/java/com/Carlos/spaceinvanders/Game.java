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
        //Ja foi criado no MENU
        /*
        TerminalSize terminalSize = new TerminalSize(80,30); // ??
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        //Create Screen

        screen = new TerminalScreen(terminal);
            */
        this.screen = screen;
        this.screen.setCursorPosition(null); // we don't nenulled a cursor
        this.screen.startScreen(); // screens must be started
        this.screen.doResizeIfNecessary(); // resize screen if necessary

        graphics = screen.newTextGraphics();
    }


    public void run() throws IOException, InterruptedException {
        //Process aqui
        //Faz sentido ter um screen.pollInput aqui
        while (true) {
           drawGame();
           KeyStroke key = screen.pollInput(); // Usar pollinput Impedir que o game, nao se esteja sempre a reescrever
           if(key != null){
               arenaControl = new arenaControl(key,arena.getArenaModel());
                if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                    screen.close();
                if (key.getKeyType() == KeyType.EOF) {
                    break;
                }
            }
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