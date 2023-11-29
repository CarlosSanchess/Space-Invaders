package com.Carlos.spaceinvaders;
import com.Carlos.spaceinvaders.controller.menu.MenuController;
import com.Carlos.spaceinvaders.model.builders.FPS;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.menu.*;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.awt.*;
import java.io.IOException;
import java.security.Key;
import java.util.Objects;

public class Menu {


    LanternaGui GUI;

    MenuModel menu = new MenuModel();
    private final DrawMenu drawMenu = new DrawMenu(menu);
    private final MenuController menuController = new MenuController(menu);

    Menu() throws IOException, FontFormatException {
        this.GUI = new LanternaGui(getScreenSize().getX() / 25, getScreenSize().getY() / 25);
    }
    public void run() throws InterruptedException, IOException, FontFormatException {
        String key;

        while(true) {
            key = GUI.getUserInput();
            drawMenu.lanternaDraw(GUI);

            if(!Objects.equals(key, null))
                menuController.toDo(key);

            if(Objects.equals(key, "Quit")){
                Game game = new Game();
                GUI.getScreen().close();
                game.run();
            }
            Thread.sleep(FPS.getFps(45));
        }
    }
    public PositionModel getScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new PositionModel(screenSize.width, screenSize.height);
    }
}
