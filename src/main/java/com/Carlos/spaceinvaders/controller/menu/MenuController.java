package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.MenuModel;

import java.util.Objects;

public class MenuController extends Controller<MenuModel> {
    //TODO TORNAR MAIS LEGIVEL
    private MenuModel menuModel;
    public MenuController(MenuModel menuModel){
        super(menuModel);
    }

    public void nextEntry(){
        int entry = super.getModel().getEntry();
        int lenEntries = super.getModel().getEntriesSize();

        super.getModel().setEntry((entry + 1) % lenEntries);
    }
    public void previousEntry() {
        if (super.getModel().getEntry() == 0) {
            super.getModel().setEntry(super.getModel().getEntriesSize() - 1);
        } else {
            super.getModel().setEntry(super.getModel().getEntry() - 1);
        }
    }
    public void toDo(String keyPressed){
        if(Objects.equals(keyPressed, "ArrowDown")) nextEntry();
        if(Objects.equals(keyPressed,"ArrowUp")) previousEntry();
    }

}
