package com.Carlos.spaceinvaders;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.menu.*;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.awt.*;
import java.io.IOException;

public class Menu {


    LanternaGui GUI;
    private KeyStroke key;
    MenuModel menu = new MenuModel();
    private final DrawMenu drawMenu = new DrawMenu(menu);
    Menu() throws IOException, FontFormatException {
        this.GUI = new LanternaGui(getScreenSize().getX() / 25, getScreenSize().getY() / 25);
    }
    public void run() throws InterruptedException, IOException, FontFormatException {
        while(true) {
            drawMenu.lanternaDraw(GUI);
            System.out.println("Press Enter To Go To Game");
            Thread.sleep(200); // Refresh the menu every second
            key = GUI.getScreen().readInput(); // Apenas para mostrar o game, mal implementado.

            if(key.getKeyType() ==  KeyType.Enter){
                Game game = new Game();
                GUI.getScreen().close();
                game.run();
            }
        }
    }
    public PositionModel getScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new PositionModel(screenSize.width, screenSize.height);
    }
}
