package com.Carlos.spaceinvanders.GUI;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;


import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class LanternaGui {

    private TextGraphics graphics;
    public LanternaGui(int widht, int height) throws IOException {
        Terminal terminal = createTerminal(widht, height);
        Screen screen = createScreen(terminal);
        graphics = createGraphics(screen);
    }

    private Terminal createTerminal(int width, int height) throws  IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

        Terminal terminal  = terminalFactory.createTerminal();

        return terminal;
    }


        private Screen createScreen(Terminal terminal) throws IOException {
            final Screen screen;
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            return screen;
        }

        private TextGraphics createGraphics(Screen screen){
            TextGraphics graphics = screen.newTextGraphics();
            return graphics;
        }

    public TextGraphics getGraphics() {
        return graphics;
    }
}
