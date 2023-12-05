package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PowerUp.PowerUp;
import com.Carlos.spaceinvaders.view.Viewer;

import java.util.List;

public class DrawPowerUps extends Viewer<List<PowerUp>> implements DrawElement{
    public DrawPowerUps(List<PowerUp> PowerUp){
        super(PowerUp);
    }

    @Override
    public void draw(LanternaGui GUI){
        for (PowerUp PowerUp : getModel()) {
            DrawPowerUp drawPowerUp = new DrawPowerUp(PowerUp);
            drawPowerUp.draw(GUI);
        }
    }
}
