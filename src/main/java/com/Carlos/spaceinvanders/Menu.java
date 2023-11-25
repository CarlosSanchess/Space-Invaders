package com.Carlos.spaceinvanders;
import com.Carlos.spaceinvanders.UI.View.Menu.*;
import com.Carlos.spaceinvanders.Entities.Model.MenuModel;
import com.Carlos.spaceinvanders.GUI.LanternaGui;

import java.awt.*;
import java.io.IOException;

public class Menu {


    LanternaGui GUI;
    MenuModel menu = new MenuModel();
    private final DrawMenu drawMenu = new DrawMenu(menu);
    Menu() throws IOException, FontFormatException {
        this.GUI = new LanternaGui(80,30);
    }
    public void run() throws InterruptedException, IOException {
        while(true) {
            drawMenu.lanternaDraw(GUI);
            Thread.sleep(200); // Refresh the menu every second
        }
    }
}
