package com.Carlos.spaceinvanders;


import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.List;
//TODO
//Implementar um drawArena Decente
//Implementar um drawBullets
//Implementar um shootingFuilod
//Tirar o processKey do model da Arena

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
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