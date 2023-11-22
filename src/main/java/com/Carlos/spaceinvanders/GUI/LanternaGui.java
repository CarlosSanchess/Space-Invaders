package com.Carlos.spaceinvanders.GUI;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;


import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class LanternaGui {
    private Screen screen;
    public LanternaGui(int widht, int height) throws IOException {
        Terminal terminal = createTerminal(widht, height);
        screen = createScreen(terminal);

}

    private Terminal createTerminal(int width, int height) throws  IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
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
}
