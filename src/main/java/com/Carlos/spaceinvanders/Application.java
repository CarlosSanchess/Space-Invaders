package com.Carlos.spaceinvanders;


import java.io.IOException;
import java.util.List;
//TODO
//IMPLEMENTAR UM SHOOTING MAIS FUILDO
// PODER MOVER APOS A BULLET DEIXAR DE ESTAR ATIVA
// MULTI SHOOTING

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.run();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}