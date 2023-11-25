package com.Carlos.spaceinvanders.UI.View.Game;
import com.Carlos.spaceinvanders.Models.Model.PlayerModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.Carlos.spaceinvanders.UI.View.Viewer;
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

