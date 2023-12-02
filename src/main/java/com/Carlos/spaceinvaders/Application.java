package com.Carlos.spaceinvaders;

import java.awt.*;
import java.io.IOException;

//TODO
//Alterar entre estados


public class Application {
    public static void main(String[] args) {
        try {

            Game menu1 = new Game();
            menu1.run();



        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
    }
}