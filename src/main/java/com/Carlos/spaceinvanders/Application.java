package com.Carlos.spaceinvanders;

import java.io.IOException;

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