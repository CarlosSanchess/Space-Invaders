package com.Carlos.spaceinvanders.UI.Menu;
import com.Carlos.spaceinvanders.Entities.Builders.menuString;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.Carlos.spaceinvanders.Entities.Menu.menuModel;

public class drawTitle implements drawMenu {

    private int row;
    private menuModel menuModel; // Onde vamos buscar o titlo e os outros atributos
    public drawTitle(){
        menuModel = new menuModel();
    }

    public void drawTitle(TextGraphics graphics){
        TextColor textColor = new TextColor.RGB(178,73,210) ;
        TextColor backgroundColor = new TextColor.RGB(0, 0, 0);

        graphics.setForegroundColor(textColor);
        graphics.setBackgroundColor(backgroundColor);
        graphics.enableModifiers(SGR.BOLD);

        String[] lines = menuModel.getTitle().split("\n");
        row = 0;
        for (String line : lines) {
            graphics.putString(7, row, line);
            row++;
        }
    }
    public void drawOptions(TextGraphics graphics){ // Deveria haver mais
        TextColor textColor = new TextColor.RGB(255,255,0);

        graphics.setForegroundColor(textColor);
        graphics.putString(33, row + 5, menuModel.getStartGame());
    }
    @Override
    public void draw(TextGraphics graphics){
        drawTitle(graphics);
        drawOptions(graphics);
    }
}
