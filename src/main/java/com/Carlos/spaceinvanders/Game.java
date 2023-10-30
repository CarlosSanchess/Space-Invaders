package com.Carlos.spaceinvanders;
import com.Carlos.spaceinvanders.Entities.arenaModel;


import com.Carlos.spaceinvanders.Entities.playerModel;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;




import java.io.IOException;



public class Game {
    private Screen screen;
    private TextGraphics graphics;
    private TextGraphics graphicsBullet;
    private int sizeX = 80;
    private int sizeY = 30;


     arenaModel arena = new arenaModel(sizeX,sizeY);
    Game(Screen screen) throws IOException{ //Melhor pratica que try catch
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

        while (true) {
           drawGame();
           KeyStroke key = screen.readInput();
           arena.processKey(key);

                if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                    screen.close();
                if (key.getKeyType() == KeyType.EOF) {
                    break;
                }
            }

        }

    public void drawGame() throws  IOException{
        screen.clear();
        arena.Draw(graphics);
        screen.refresh();
    }

}