package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Entities.Model.ArenaModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;

//Jogo consiste até agr num objeto arena com todas as entities
public class DrawGame extends Viewer<ArenaModel> {

    public DrawGame(ArenaModel arenaModel){
        super(arenaModel);
    }
    @Override
    public void draw(LanternaGui GUI) { //TODO OTIMIZAR ESTE DRAW
        DrawPlayer drawPlayer = new DrawPlayer(super.getModel().getPlayer());
        drawPlayer.draw(GUI);

        DrawMonsters drawMonsters = new DrawMonsters(super.getModel().getActiveMonsters());
        drawMonsters.draw(GUI);

        DrawBullets drawBullets = new DrawBullets(super.getModel().getActiveBullets());
        drawBullets.draw(GUI);

        DrawOutline drawWalls = new DrawOutline(super.getModel().getWalls());
        drawWalls.draw(GUI);
    }
}
