package com.Carlos.spaceinvanders.Controls;

import com.Carlos.spaceinvanders.Entities.arenaModel;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class arenaControl {

       private KeyStroke key;
       private arenaModel arenaModel;

       public arenaControl(KeyStroke key,arenaModel arenaModel) throws IOException, InterruptedException {
           this.key = key;
           this.arenaModel = arenaModel;
           processKey(this.key);

       }

    public void processKey(KeyStroke key) throws IOException, InterruptedException { // Aqui ou no controls package ou no game

        switch (key.getKeyType()) {
            case ArrowLeft:
                arenaModel.getPlayer().moveLeft(arenaModel.getPlayer().getPosition());
                break;
            case ArrowRight:
                arenaModel.getPlayer().moveRight(arenaModel.getPlayer().getPosition());
                break;
            case Backspace: //ADD CANSHOOT? nerfar a arma, possivle
                arenaModel.getActiveBullets().add(arenaModel.getPlayer().playerShoot()); //Ok
                break;
        }
        if(key.getCharacter() != null) {
            switch (key.getCharacter()) {
                case 'a','A'-> arenaModel.getPlayer().moveLeft(arenaModel.getPlayer().getPosition());
                case 'd','D' -> arenaModel.getPlayer().moveRight(arenaModel.getPlayer().getPosition());

            }
        }
    }

}
