package com.Carlos.spaceinvaders.view;



import com.Carlos.spaceinvaders.gui.LanternaGui;

import java.io.IOException;

public abstract class Viewer <T>{  // Este viewer, da display do jogo e do menu.
    //Inicializar o viewer e chamar o lanternadraw no gameloop

    private final T model;

    public Viewer(T model){
        this.model = model;
    }

    public void lanternaDraw(LanternaGui GUI) throws IOException {
        GUI.screenClear();
        draw(GUI);
        GUI.screenRefresh();
    }
    public T getModel(){
        return model;
    }
    protected abstract void draw(LanternaGui GUI);
}
