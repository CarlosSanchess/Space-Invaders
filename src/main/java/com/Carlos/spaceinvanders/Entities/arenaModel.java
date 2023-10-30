package com.Carlos.spaceinvanders.Entities;
import com.Carlos.spaceinvanders.Entities.Builders.Builders;
import com.Carlos.spaceinvanders.UI.drawPlayer;
import com.Carlos.spaceinvanders.UI.drawBullets;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//If active bullets Draw bullets, mover player
//ELse mover player apenas
public class arenaModel {

    private int width;
    private int height;

    private List<bulletModel> activeBullets;
    private List<wallModel> walls;
    private playerModel player;
    private drawPlayer drawPlayer;
    private drawBullets drawBullets;


    public arenaModel(int x, int y){
        this.width = x;
        this.height = y;
        this.player = new playerModel(new positionModel(10,y - 1),3);
        this.activeBullets = new ArrayList<>();
        walls = Builders.createWalls(width,height);
        drawPlayer = new drawPlayer(this.player);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }


   public void Draw(TextGraphics graphics) throws IOException { // Tirar daqui esta merda
            drawPlayer.draw(graphics);
            drawBullets = new drawBullets(activeBullets);
            drawBullets.draw(graphics);
    }

    public void processKey(KeyStroke key) throws IOException, InterruptedException { // Aqui ou no controls package ou no game

            switch (key.getKeyType()) {
                case ArrowLeft:
                    player.moveLeft(player.getPosition());
                    break;
                case ArrowRight:
                    player.moveRight(player.getPosition());

                    break;
                case Backspace:
                    activeBullets.add(player.playerShoot());
                    break;

            }
        if(key.getCharacter() != null) {
            switch (key.getCharacter()) {
                case 'a','A'-> player.moveLeft(player.getPosition());
                case 'd','D' -> player.moveRight(player.getPosition());

            }
        }
    }

    public playerModel getPlayer() {
        return player;
    }
}
