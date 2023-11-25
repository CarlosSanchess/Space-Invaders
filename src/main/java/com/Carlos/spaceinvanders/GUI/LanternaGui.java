package com.Carlos.spaceinvanders.GUI;

import com.Carlos.spaceinvanders.Entities.Model.MenuModel;
import com.Carlos.spaceinvanders.Entities.Model.PositionModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LanternaGui {

    private TextGraphics graphics;
    private Screen screen;

    public LanternaGui(int width, int height) throws IOException, FontFormatException {
        Terminal terminal = createTerminal(width, height);
        screen = createScreen(terminal);
        graphics = createGraphics(screen);
    }

    private Terminal createTerminal(int width, int height) throws IOException, FontFormatException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        
        AWTTerminalFontConfiguration fontConfig = fontLoader();
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        
        terminalFactory.setForceAWTOverSwing(true);
        
        terminalFactory.setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        AWTTerminalFrame terminalFrame = (AWTTerminalFrame) terminal;
        windowClosing(terminalFrame);
        return terminal;
    }

    private void windowClosing(AWTTerminalFrame terminal) {
        terminal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent close) {
                close.getWindow().dispose();
            }
        });
    }

    private AWTTerminalFontConfiguration fontLoader() throws FontFormatException, IOException {
        InputStream fontStream = getClass().getClassLoader().getResourceAsStream("fonts/CosmicAlien.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 30);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    private Screen createScreen(Terminal terminal) {
        try {
            Screen screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            return screen;
        } catch (IOException e) {
            System.err.println("Error creating screen: " + e.getMessage());
            return null;
        }
    }

    private TextGraphics createGraphics(Screen screen) {
        return screen.newTextGraphics();
    }

    public void drawText(PositionModel position, String string, TextColor.RGB rgbColor) {
        drawText(position, string, rgbColor, false);
    }

    public void drawText(PositionModel position, String string, TextColor.RGB rgbColor, boolean bold) {
        if (bold)
            graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor(rgbColor);
        graphics.putString(position.getX(), position.getY(), string);
    }

    public void screenClear() {
        screen.clear();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#010327"));
        graphics.fillRectangle(new TerminalPosition(0, 0), screen.getTerminalSize(), ' ');
    }

    public void screenRefresh() throws IOException {
        screen.refresh();
    }

    public void drawTitle(String string) {
        screenClear();
        String[] lines = string.split("\n");
        int y = 0;
        for (String line : lines) {
            drawText(new PositionModel(7, y), line, new TextColor.RGB(178, 73, 210),Boolean.TRUE);
            y++;
        }
    }

    public void drawEntries(MenuModel menuModel) {
        List<String> entries = menuModel.getEntries();
        int y = 10;
        for (String entry : entries) {
            TextColor.RGB color = menuModel.getColor(entry);
            graphics.setBackgroundColor(TextColor.Factory.fromString("#010327"));
            drawText(new PositionModel(33, y), entry, color,Boolean.TRUE);
            y += 3;
        }
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
    }
}