package com.Carlos.spaceinvanders;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Player {

    private Position position;

    Player(int x, int y) {
        position = new Position(x, y);
    }

    void Draw(TextGraphics graphics) {
        //screen.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "V");
    }
    public void setPosition(int x){
        position.setX(x);
    }
    public Position getPosition(){
        return position;
    }

}
