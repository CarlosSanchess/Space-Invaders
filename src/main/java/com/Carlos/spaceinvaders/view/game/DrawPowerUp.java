package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;

import com.Carlos.spaceinvaders.model.models.PowerUp;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawPowerUp extends Viewer<PowerUp> implements DrawElement {

    public DrawPowerUp(PowerUp powerUp){
        super(powerUp);
    }
    @Override
    public void draw(LanternaGui GUI){
        PowerUp powerUp = getModel();
        if(powerUp.isActive() != 2){
            if(powerUp.getPowerUpType() == PowerUp.PowerUpType.HealthBoost)
                GUI.drawText(powerUp.getPosition(),"+",new TextColor.RGB(0,255,0));
            if(powerUp.getPowerUpType() == PowerUp.PowerUpType.ScoreBoost)
                GUI.drawText(powerUp.getPosition(),"★",new TextColor.RGB(255,255,0));
            if(powerUp.getPowerUpType() == PowerUp.PowerUpType.FireRateBoost)
                GUI.drawText(powerUp.getPosition(),"F",new TextColor.RGB(0,0,255));
        }
    }
}