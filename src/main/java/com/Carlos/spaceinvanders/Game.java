package com.Carlos.spaceinvanders;

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
    private final Screen screen;
    private TextGraphics graphics;
    private int sizeX = 80;
    private int sizeY = 30;

    Arena arena = new Arena(sizeX,sizeY);
    Game() throws IOException{ //Melhor pratica que try catch
            //Create Terminal
            TerminalSize terminalSize = new TerminalSize(80,30); // ??
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            //Create Screen
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null); // we don't nenulled a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
    }
    public void run() throws IOException{
        graphics = screen.newTextGraphics();
        while(true) {
            drawGame();
            KeyStroke key = screen.readInput();
            processKey(key);

            if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                screen.close();
            if (key.getKeyType() == KeyType.EOF){
                break;
            }
        }
    }
    private void processKey(KeyStroke key) throws IOException{
        switch (key.getKeyType()){
            case ArrowLeft -> arena.moveLeft();
            case ArrowRight -> arena.moveRight();
            case Backspace -> drawBullets();
        }
    }
    private void drawGame() throws IOException{
        screen.clear();
        arena.Draw(graphics);
        screen.refresh();
    }
    private void drawBullets()throws IOException{
        screen.clear();
        System.out.println("*b*");
        arena.drawBullet(graphics,screen);
        screen.refresh();
    }
}
