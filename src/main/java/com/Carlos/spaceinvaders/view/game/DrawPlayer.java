package com.Carlos.spaceinvaders.view.game;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;




public class DrawPlayer extends Viewer<PlayerModel> implements DrawElement {
    public DrawPlayer(PlayerModel player){
        super(player);
    }

    @Override
    public void draw(LanternaGui GUI) {
        PlayerModel playerModel = getModel();
        GUI.drawText(playerModel.getPosition(),"P",new TextColor.RGB(0,255,0));
    }
}

