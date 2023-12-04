package com.Carlos.spaceinvaders.view.game;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;




public class DrawPlayer extends Viewer<PlayerModel> implements DrawElement {
    public DrawPlayer(PlayerModel player){
        super(player);
    }

    @Override
    public void draw(LanternaGui GUI) {
        PlayerModel playerModel = getModel();
        PositionModel position = playerModel.getPosition();//Added do draw SpaceShip
        drawSpaceship(GUI, position);//Added do draw SpaceShip
        //GUI.drawText(playerModel.getPosition(),"P",new TextColor.RGB(0,255,0));
    }

    private void drawSpaceship(LanternaGui gui, PositionModel position) {
        int x = position.getX();
        int y = position.getY();

        gui.getGraphics().setBackgroundColor(TextColor.Factory.fromString("#010327")); // Use your default background color
        gui.drawText(new PositionModel(x, y - 2), "|", new TextColor.RGB(0, 255, 0), false);
        gui.drawText(new PositionModel(x - 2, y - 1), " /", new TextColor.RGB(0, 255, 0), false);

        //gui.getGraphics().setBackgroundColor(TextColor.Factory.fromString("#00FF00")); // Use your default background color
        gui.drawText(new PositionModel(x, y - 1), " ", new TextColor.RGB(0, 255, 0), false);

        //gui.getGraphics().setBackgroundColor(TextColor.Factory.fromString("#010327")); // Use your default background color
        gui.drawText(new PositionModel(x + 1, y - 1), "\\ ", new TextColor.RGB(0, 255, 0), false);
        gui.drawText(new PositionModel(x - 2, y), "<", new TextColor.RGB(0, 255, 0), false);

        //gui.getGraphics().setBackgroundColor(TextColor.Factory.fromString("#00FF00")); // Use your default background color
        gui.drawText(new PositionModel(x - 1, y), "   ", new TextColor.RGB(0, 255, 0), false);

        //gui.getGraphics().setBackgroundColor(TextColor.Factory.fromString("#010327")); // Use your default background color
        gui.drawText(new PositionModel(x + 2, y), ">", new TextColor.RGB(0, 255, 0), false);
        //gui.getGraphics().setBackgroundColor(TextColor.Factory.fromString("#010327")); // Use your default background color
        gui.drawText(new PositionModel(x - 1, y), "___", new TextColor.RGB(0, 255, 0), false);

    }
}

