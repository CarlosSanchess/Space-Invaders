package com.Carlos.spaceinvanders.UI.View;



import com.Carlos.spaceinvanders.GUI.LanternaGui;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public abstract class Viewer <T>{  // Este viewer, da display do jogo por completo, e do menu.

    private final T model;

    public Viewer(T model){
        this.model = model;
    }

    void draw(LanternaGui GUI) throws IOException {
        GUI.screenClear();
        drawGame(GUI);
        GUI.screenRefresh();
    }
    abstract void drawGame(LanternaGui GUI);
}
