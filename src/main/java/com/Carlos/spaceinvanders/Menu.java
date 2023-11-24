package com.Carlos.spaceinvanders;

import com.Carlos.spaceinvanders.UI.View.Menu.*;
import com.Carlos.spaceinvanders.Entities.Model.MenuModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;
import java.io.IOException;

public class Menu {


    LanternaGui GUI;

    Menu() throws IOException, InterruptedException {
        this.GUI = new LanternaGui(80,30);
        MenuModel menu = new MenuModel();
    }
    public void run() throws IOException, InterruptedException {
        while(true) {

            Thread.sleep(200); // Refresh the menu every second
        }
    }
}


/*
private void processKey(KeyStroke key) throws IOException, InterruptedException { // Melhorar a oragnização de codigo tirar process Key
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q')) {
            screen.clear();
            screen.refresh();
            game = new Game(this.screen); //Sera que faz sentido ter isto aqui?
            game.run();
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('Q')) {

            screen.clear();
            screen.refresh();
            game = new Game(this.screen); //Sera que faz sentido ter isto aqui?
            game.run();
        }
    }

    Processkey ??
 */