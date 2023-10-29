package com.Carlos.spaceinvanders.Entities;
import com.Carlos.spaceinvanders.Entities.Builders.Builders;
import com.Carlos.spaceinvanders.UI.playerDraw;

import com.Carlos.spaceinvanders.Bullet;
import com.Carlos.spaceinvanders.Player;
import com.Carlos.spaceinvanders.Wall;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class arenaModel {

    private int width;
    private int height;

    private List<bulletModel> activeBullets;
    private List<wallModel> walls;
    private playerModel player;

    public arenaModel(int x, int y){
        this.width = width;
        this.height = height;
        this.player = new playerModel(new positionModel(10,10),3);
        this.activeBullets = new ArrayList<>();
        walls = Builders.createWalls(width,height);
    }


    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void addBullet() {
        activeBullets.add(new bulletModel(player.getPosition(),1,true));
    }

   public void Draw(TextGraphics graphics){
       playerDraw playerDraw = new playerDraw(this.player);
       playerDraw.draw(graphics);
   }
    public void processKey(KeyStroke key) throws IOException{ // Aqui ou no controls package ou no game
        switch (key.getKeyType()){
            case ArrowLeft -> player.moveLeft(player.getPosition());
            case ArrowRight -> player.moveRight(player.getPosition());
        }
    }

}
