package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;

import com.Carlos.spaceinvaders.model.models.PowerUp.PowerUp;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

public class DrawPowerUp extends Viewer<PowerUp> implements DrawElement {

    public DrawPowerUp(PowerUp powerUp){
        super(powerUp);
    }
    @Override
    public void draw(LanternaGui GUI){
        PowerUp powerUp = getModel();
        GUI.drawText(powerUp.getPosition(),"P",new TextColor.RGB(255,255,0));
    }
}