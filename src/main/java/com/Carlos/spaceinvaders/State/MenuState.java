package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
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
    private Game game;
    public MenuState(MenuModel menuModel, Game game){
        super(menuModel);
        this.game = game;
        this.drawMenu = new DrawMenu(super.getModel()); // TODO alternativa para isto
        this.menuController = new MenuController(super.getModel(),game);
    }

    @Override
    public void step(String Key, LanternaGui GUI, long Time) throws IOException {
        drawMenu.lanternaDraw(GUI);
        menuController.toDo(Key, Time);
    }

}
