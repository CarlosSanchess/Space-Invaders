package com.Carlos.spaceinvanders;

import java.awt.*;
import java.io.IOException;

//TODO
//Implementar um drawArena Decente
//Tirar o processKey do model da Arena
//Nerfar o shooting, implementar movimentos while shooting

public class Application {
    public static void main(String[] args) {
        try {

            Menu menu1 = new Menu();
            menu1.run();



        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
    }
}