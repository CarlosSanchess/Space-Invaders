package com.Carlos.spaceinvanders.UI;
import com.Carlos.spaceinvanders.Entities.arenaModel;
import com.googlecode.lanterna.graphics.TextGraphics;

//TODO,
//IS safe to have the drawobjects public, in arenamodel, so we dont have that num of getters.
public class drawArena implements drawEntities {

    arenaModel arenaModel;

    public drawArena(arenaModel arenaModel){
        this.arenaModel = arenaModel;
    }

    @Override
    public void draw(TextGraphics graphics) {
        drawPlayer drawPlayer = arenaModel.getDrawPlayer();
        drawOutline drawOutline = arenaModel.getDrawOutline();
        drawMonsters drawMonsters = arenaModel.getDrawMonsters();
        drawBullets drawBullets;

        drawPlayer.draw(graphics);
        drawOutline.draw(graphics);
        drawMonsters.draw(graphics);

        if (!(arenaModel.getActiveBullets().isEmpty())) {
            drawBullets = new drawBullets(arenaModel.getActiveBullets());
            drawBullets.draw(graphics);
        }
    }
}
