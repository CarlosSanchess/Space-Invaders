package com.Carlos.spaceinvanders;

import java.io.IOException;

//TODO
//Implementar um drawArena Decente
//Tirar o processKey do model da Arena
//Nerfar o shooting, implementar movimentos while shooting

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