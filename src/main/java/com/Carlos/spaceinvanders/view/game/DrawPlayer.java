package com.Carlos.spaceinvanders.view.game;
import com.Carlos.spaceinvanders.model.models.PlayerModel;
import com.Carlos.spaceinvanders.gui.LanternaGui;
import com.Carlos.spaceinvanders.view.Viewer;
import com.googlecode.lanterna.TextColor;




public class DrawPlayer extends Viewer<PlayerModel> implements DrawElement {
    public DrawPlayer(PlayerModel player){
        super(player);
    }

    @Override
    public void draw(LanternaGui GUI) {
        PlayerModel playerModel = super.getModel();
        GUI.drawText(playerModel.getPosition(),"P",new TextColor.RGB(0,255,0));
    }
}

