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
            case Backspace -> threads();
        }
    }
    private void drawGame() throws IOException{
        screen.clear();
        arena.drawArena(graphics);
        screen.refresh();
    }

    private void threads() throws IOException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(drawBullets());
        Thread.sleep(100);
        executor.submit(drawBullets());
        executor.submit(gameRunnable());
    }

    public Runnable drawBullets() { //Returnar um runnable de drawBullets
        return () -> {
            try {
                screen.clear();
                System.out.println("*b*");
                arena.drawBullet(graphics, screen);
                screen.refresh();
            }catch (IOException e){
                e.printStackTrace();
            }
        };
    }
    public Runnable gameRunnable(){
        return () ->{
            try {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    drawGame();
                    KeyStroke key = screen.readInput();
                    processKey(key);

                    if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                        screen.close();
                    if (key.getKeyType() == KeyType.EOF) {
                        break;
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

}