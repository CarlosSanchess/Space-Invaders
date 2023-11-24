package com.Carlos.spaceinvanders.UI.View.Game;

import com.Carlos.spaceinvanders.Entities.Model.ArenaModel;
import com.Carlos.spaceinvanders.Entities.Model.BulletModel;
import com.Carlos.spaceinvanders.Entities.Model.MonsterModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;

import java.util.List;

//Jogo consiste até agr num objeto arena com todas as entities
public class DrawGame extends Viewer<ArenaModel> {

    public DrawGame(ArenaModel arenaModel){
        super(arenaModel);
    }
    @Override
    public void draw(LanternaGui GUI) {
        DrawPlayer drawPlayer = new DrawPlayer(super.getModel().getPlayer());
        drawPlayer.draw(GUI);

        DrawMonsters drawMonsters = new DrawMonsters(super.getModel().getActiveMonsters());
        drawMonsters.draw(GUI);

        DrawBullets drawBullets = new DrawBullets(super.getModel().getActiveBullets());
        drawBullets.draw(GUI);
    }
}
