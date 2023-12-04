package com.Carlos.spaceinvaders.controller.menu;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.MenuState;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.model.models.OptionsModel;

import java.util.Objects;

public class OptionsController extends Controller<OptionsModel> {
    public OptionsController(OptionsModel option) {
        super(option);
    }

    @Override
    public void toDo(Game game, String keyPressed, long Time) {
        if (Objects.equals(keyPressed, "Enter")) game.pushState(new MenuState(new MenuModel()));
    }
}