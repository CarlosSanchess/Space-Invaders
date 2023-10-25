package com.Carlos.spaceinvanders;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private TextGraphics graphics;

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
    }
}
