package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.controller.game.GameController;
import com.Carlos.spaceinvaders.controller.menu.MenuController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.view.game.DrawGame;
import com.Carlos.spaceinvaders.view.menu.DrawMenu;

import java.io.IOException;

public  class MenuState extends State<MenuModel> {

    private  DrawMenu drawMenu;
    private  MenuController menuController;
    public MenuState(MenuModel menuModel){
        super(menuModel);
    }

    DrawMenu getViewer(){
        return drawMenu;
    }

    MenuController getControllers(){
        return menuController;
    }
    @Override
    public void step(String Key, LanternaGui GUI) throws IOException {
        this.drawMenu = new DrawMenu(super.getModel());
        this.menuController = new MenuController(super.getModel());
        drawMenu.lanternaDraw(GUI);
        menuController.toDo(Key);
    }

}
