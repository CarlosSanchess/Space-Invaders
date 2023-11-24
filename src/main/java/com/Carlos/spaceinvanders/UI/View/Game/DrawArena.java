package com.Carlos.spaceinvanders.UI.View.Game;
import com.Carlos.spaceinvanders.Entities.Model.ArenaModel;
import com.googlecode.lanterna.graphics.TextGraphics;

//TODO,
//IS safe to have the drawobjects public, in arenamodel, so we dont have that num of getters.
public class DrawArena implements DrawEntities {

    ArenaModel arenaModel;

    public DrawArena(ArenaModel arenaModel){
        this.arenaModel = arenaModel;
    }

    @Override
    public void draw(TextGraphics graphics) {
        /*
       // DrawPlayer drawPlayer = arenaModel.getDrawPlayer();
       // DrawOutline drawOutline = arenaModel.getDrawOutline();
        DrawMonsters drawMonsters = arenaModel.getDrawMonsters();
        DrawBullets drawBullets;

        drawPlayer.draw(graphics);
        drawOutline.draw(graphics);
        drawMonsters.draw(graphics);

        if (!(arenaModel.getActiveBullets().isEmpty())) {
            drawBullets = new DrawBullets(arenaModel.getActiveBullets());
            drawBullets.draw(graphics);
        }
        */
    }
}
