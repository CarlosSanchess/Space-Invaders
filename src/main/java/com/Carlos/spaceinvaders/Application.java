package com.Carlos.spaceinvaders;

import java.awt.*;
import java.io.IOException;

//TODO


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