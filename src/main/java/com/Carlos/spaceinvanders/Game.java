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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    private final Screen screen;
    private TextGraphics graphics;
    private TextGraphics graphicsBullet;
    private int sizeX = 80;
    private int sizeY = 30;
    private int numberthreads = 0;

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

        graphics = screen.newTextGraphics();
    }


    public void run() throws IOException, InterruptedException {

            while (true) {
                    drawGame();
                    KeyStroke key = screen.readInput();
                    System.out.println("asdsa");
                    processKey(key);

                if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                    screen.close();
                if (key.getKeyType() == KeyType.EOF) {
                    break;
                }
            }
    }


    private void processKey(KeyStroke key) throws IOException, InterruptedException {
        switch (key.getKeyType()){
            case ArrowLeft -> arena.moveLeft();
            case ArrowRight -> arena.moveRight();
            case Backspace -> arena.addBullet();
        }
    }
    private void drawGame() throws IOException{
        screen.clear();
        arena.drawArena(graphics);
        screen.refresh();

    }



}