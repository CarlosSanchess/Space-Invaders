package com.Carlos.spaceinvanders.UI;
import com.Carlos.spaceinvanders.Entities.arenaModel;
import com.Carlos.spaceinvanders.Entities.bulletModel;
import com.Carlos.spaceinvanders.Entities.playerModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class drawArena implements drawEntities {

    arenaModel arenaModel;
    public drawArena(arenaModel arenaModel){
        this.arenaModel = arenaModel;
    }

    @Override
    public void draw(TextGraphics graphics) {

    }
}
