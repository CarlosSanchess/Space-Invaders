package com.Carlos.spaceinvaders;

import java.awt.*;
import java.io.IOException;

//TODO
//Caixas do Menu estão a desenhar com fundo preto

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