package com.Carlos.spaceinvaders.gui;

import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LanternaGui {

    private TextGraphics graphics;
    private Screen screen;
    private int width;
    private int height;

    private int startPoint;


    public LanternaGui(int width, int height) throws IOException, FontFormatException {
        Terminal terminal = createTerminal(width, height);
        this.width = width;
        this.height = height;
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
        terminalFrame.setTitle("Space Invaders");
        windowClosing(terminalFrame);
        return terminal;
    }

    private void windowClosing(AWTTerminalFrame terminal) {
        terminal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent close) {
                close.getWindow().dispose();
                System.exit(0); //To stop exec
            }
        });
    }

    private AWTTerminalFontConfiguration fontLoader() throws FontFormatException, IOException {
        InputStream fontStream = getClass().getClassLoader().getResourceAsStream("fonts/CosmicAlien.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
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
    public String getUserInput() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return null;
        if (keyStroke.getKeyType() == KeyType.EOF) return "Quit";
        if (keyStroke.getKeyType() == KeyType.Escape) return "Escape";
        if (keyStroke.getKeyType() == KeyType.Character) {
            char character = keyStroke.getCharacter();
            if (character == 'q' || character == 'Q') return "Quit";
        }
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return "ArrowUp";
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return "ArrowRight";
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return "ArrowDown";
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return "ArrowLeft";
        if (keyStroke.getKeyType() == KeyType.Enter) return "Enter";
        if (keyStroke.getKeyType() == KeyType.Backspace) return "BackSpace";
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ') return "Space";


        return null;
    }
    private TextGraphics createGraphics(Screen screen) {
        return screen.newTextGraphics();
    }

    public void setGraphics(TextGraphics graphics) {
        this.graphics = graphics;
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
    public Screen getScreen(){
        return screen;
    }
    public void setScreen(Screen screen) {
        this.screen = screen;
    }


    public void drawTitle(String string) {
        if(string.length() == 522){
            startPoint = (width - 64) / 2;

            String[] lines = string.split("\n");
            int y = 2;
            for (String line : lines) {
                drawText(new PositionModel(startPoint, y), line, new TextColor.RGB(178, 73, 210),Boolean.TRUE);
                y++;
            }


        }else if(string.length() == 279){
            startPoint = (width - 56) / 2;

            String[] lines = string.split("\n");
            int y = 5;
            for (String line : lines) {
                drawText(new PositionModel(startPoint, y), line, new TextColor.RGB(178, 73, 210),Boolean.TRUE);
                y++;
            }
        }
        else{
            startPoint = (width - 39) / 2;

            String[] lines = string.split("\n");
            int y = 5;
            for (String line : lines) {
                drawText(new PositionModel(startPoint, y), line, new TextColor.RGB(178, 73, 210),Boolean.TRUE);
                y++;
            }
        }

    }

    public void drawEntries(MenuModel menuModel) {
        List<String> entries = menuModel.getEntries();
        int y = 14;
        for (String entry : entries) {
            TextColor.RGB color = menuModel.getColor(entry);
            int startPoint = getStartPoint(entry,width);

            graphics.setBackgroundColor(TextColor.Factory.fromString("#010327"));
            drawText(new PositionModel(startPoint, y), entry, color,Boolean.TRUE);
            y += 5;
        }
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
    }
    public void drawSelected(MenuModel menuModel){

        String Entry = menuModel.getEntries().get(menuModel.getEntry());


        graphics.setBackgroundColor(TextColor.Factory.fromString("#010327"));
        drawTop(menuModel, Entry);
        drawBottom(menuModel, Entry);
        drawLeft(menuModel, Entry);
        drawRight(menuModel, Entry);
    }

    public void drawTextSelected(PositionModel position, String entryName, TextColor.RGB rgbColor) {
        int width = entryName.length() + 2; // Adjust width for the surrounding rectangle
        int height = 3; // Adjust height for the surrounding rectangle

        // Draw the top of the surrounding rectangle
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.putString(position.getX()-1, position.getY()-1, "+");
        for (int i = 1; i < width - 1; i++) {
            graphics.putString(position.getX() - 1 + i, position.getY() - 1, "-");
        }
        graphics.putString(position.getX() - 1 + width - 1, position.getY() - 1, "+");

        // Draw the text inside the rectangle with '|'
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.putString(position.getX() - 1, position.getY() - 1 + 1, "|");
        graphics.setForegroundColor(new TextColor.RGB(0, 255 ,0));
        graphics.putString(position.getX() - 1 + 1, position.getY() - 1 + 1, entryName);
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.putString(position.getX() - 1 + width - 1, position.getY() - 1 + 1, "|");

        // Draw the bottom of the surrounding rectangle
        graphics.putString(position.getX() - 1, position.getY() - 1 + height - 1, "+");
        for (int i = 1; i < width - 1; i++) {
            graphics.putString(position.getX() - 1 + i, position.getY() - 1 + height - 1, "-");
        }
        graphics.putString(position.getX() - 1 + width - 1, position.getY() - 1 + height - 1, "+");
    }
    public int getStartPoint(String string, int width) {
        return Math.round((float)(width - string.length()) / 2);
    }

    private void drawTop(MenuModel menuModel, String Entry){
        TerminalPosition startLine = new TerminalPosition(getStartPoint(Entry,width) - 3, 12 + (5 *  menuModel.getEntry()));
        TerminalPosition endLine = new TerminalPosition(getStartPoint(Entry,width) + Entry.length() + 2, 12 + (5 *  menuModel.getEntry()) );
        graphics.drawLine(startLine, endLine, '-');
    }
    private void drawBottom(MenuModel menuModel, String Entry){
        TerminalPosition startLine = new TerminalPosition(getStartPoint(Entry,width) - 3, 16 + (5 *  menuModel.getEntry()));
        TerminalPosition endLine = new TerminalPosition(getStartPoint(Entry,width) + Entry.length() + 2, 16 + (5 *  menuModel.getEntry()) );
        graphics.drawLine(startLine, endLine, '-');
    }
    private void drawLeft(MenuModel menuModel, String Entry){
        TerminalPosition startLine = new TerminalPosition(getStartPoint(Entry,width) - 3, 12 + (5 *  menuModel.getEntry()));
        TerminalPosition endLine = new TerminalPosition(getStartPoint(Entry,width) - 3, 16 + (5 *  menuModel.getEntry()) );
        graphics.drawLine(startLine, endLine, '+');
    }
    private void drawRight(MenuModel menuModel, String Entry){
        TerminalPosition startLine = new TerminalPosition(getStartPoint(Entry,width) + Entry.length() + 2, 12 + (5 *  menuModel.getEntry()));
        TerminalPosition endLine = new TerminalPosition(getStartPoint(Entry,width) + Entry.length() + 2, 16 + (5 *  menuModel.getEntry()) );
        graphics.drawLine(startLine, endLine, '+');
    }

    public TextGraphics getGraphics() {
        return graphics;
    }

}