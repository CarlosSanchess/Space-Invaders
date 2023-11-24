package com.Carlos.spaceinvanders.GUI;

import com.Carlos.spaceinvanders.Entities.Model.PositionModel;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;


import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class LanternaGui {

    private TextGraphics graphics;
    private Screen screen;
    public LanternaGui(int widht, int height) throws IOException {
        Terminal terminal = createTerminal(widht, height);
        screen = createScreen(terminal);
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

    public void drawText(PositionModel position, String string, TextColor.RGB rgbColor){ // Testar esta função
            graphics.setForegroundColor(rgbColor);
            graphics.putString(position.getX(), position.getY(), string);
    }
    public void screenClear(){
        screen.clear();
    }
    public void screenRefresh() throws IOException {
        screen.refresh();
    }
    public void drawTitle(String string){
        String [] lines = string.split("\n");
        int y = 0;
        for (String line : lines) {
            drawText(new PositionModel(7, y), line, new TextColor.RGB(178, 73, 210));
            y++;
        }
    }
}
