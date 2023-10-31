package com.Carlos.spaceinvanders;


import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.List;
//TODO
//Implementar um drawArena Decente
//Implementar um drawBullets, usar pollinput
//Implementar um shootingFuilod
//Tirar o processKey do model da Arena

public class Application {
    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            menu.run();

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}