package com.Carlos.spaceinvanders.UI.Menu;
import com.Carlos.spaceinvanders.Entities.Builders.menuString;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class drawTitle implements drawMenu {

    String Title;// String com o title

    public drawTitle(){
        Title = menuString.getText();
    }

    @Override
    public void draw(TextGraphics graphics){
        String title = menuString.getText();
        TextColor textColor = new TextColor.RGB(178,73,210) ;
        TextColor backgroundColor = new TextColor.RGB(0, 0, 0);

        graphics.setForegroundColor(textColor);
        graphics.setBackgroundColor(backgroundColor);
        graphics.enableModifiers(SGR.BOLD);

        String[] lines = title.split("\n");
        int y = 0;
        for (String line : lines) {
            graphics.putString(7, y, line);
            y++;
        }
    }
}
