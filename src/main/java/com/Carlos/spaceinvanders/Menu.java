package com.Carlos.spaceinvanders;


import com.Carlos.spaceinvanders.UI.Menu.drawTitle;
import com.Carlos.spaceinvanders.Controls.gameCountdown;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Menu {
    private Screen screen;
    private TextGraphics graphics;
    private Terminal terminal;
    private drawTitle drawTitle = new drawTitle();
    private Game game;
    private gameCountdown gameCountdown;

    Menu() throws IOException { //Melhor pratica que try catch
        //Create Terminal e screen que ja fica para o game
        TerminalSize terminalSize = new TerminalSize(80,30); // ??
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminal = terminalFactory.createTerminal();
        //Create Screen
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null); // we don't nenulled a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary

        graphics = screen.newTextGraphics();
    }
    public void run() throws IOException, InterruptedException {
        //TODO
        //drawTItle no UI do MENU
        //ProcessKey no Controls
        screen.clear();
        drawTitle.draw(graphics);
        screen.refresh();
        Thread.sleep(200);
        while (true) { // Faz com que a primeira letra que se le, nao precise de ter significado
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }

    private void processKey(KeyStroke key) throws IOException, InterruptedException { // Melhorar a oragnização de codigo tirar process Key
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q')){
            screen.clear();
            screen.refresh();
            game = new Game(this.screen); //Sera que faz sentido ter isto aqui?
            game.run();
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('Q')){

            screen.clear();
            screen.refresh();
            game = new Game(this.screen); //Sera que faz sentido ter isto aqui?
            game.run();
        }
    }
}
