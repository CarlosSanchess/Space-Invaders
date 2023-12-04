package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.ResumeMenuController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MenuModel;
import com.Carlos.spaceinvaders.model.models.ResumeMenuModel;
import com.Carlos.spaceinvaders.view.menu.DrawMenu;
import com.Carlos.spaceinvaders.view.menu.DrawResumeMenu;

import java.io.IOException;

public class ResumeMenuState extends State<ResumeMenuModel> {

    private DrawResumeMenu drawResumeMenu;
    private ResumeMenuController ResumeMenuController;
    public ResumeMenuState(ResumeMenuModel ResumeMenuModel){
        super(ResumeMenuModel);
        this.drawResumeMenu = new DrawResumeMenu(getModel()); // TODO alternativa para isto
        this.ResumeMenuController = new ResumeMenuController(getModel());
    }

    @Override
    public void step(String Key, LanternaGui GUI, long Time, Game game) throws IOException {
        drawResumeMenu.lanternaDraw(GUI);
        ResumeMenuController.toDo(game,Key, Time);
    }
}
