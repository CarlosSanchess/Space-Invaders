package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Models.Model.ArenaModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;

public class DrawGame extends Viewer<ArenaModel> {

    public DrawGame(ArenaModel arenaModel) {
        super(arenaModel);
    }

    @Override
    public void draw(LanternaGui GUI) {
        drawElement(new DrawPlayer(super.getModel().getPlayer()), GUI);
        drawElement(new DrawMonsters(super.getModel().getActiveMonsters()), GUI);
        drawElement(new DrawBullets(super.getModel().getActiveBullets()), GUI);
        drawElement(new DrawOutline(super.getModel().getWalls()), GUI);
        drawElement(new DrawScore(super.getModel().getScore()),GUI);
    }

    private void drawElement(DrawElement element, LanternaGui GUI) {
        element.draw(GUI);
    }
}