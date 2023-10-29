package com.Carlos.spaceinvanders.Entities;
import com.Carlos.spaceinvanders.Entities.Builders.Builders;

import com.Carlos.spaceinvanders.Bullet;
import com.Carlos.spaceinvanders.Player;
import com.Carlos.spaceinvanders.Wall;

import java.util.ArrayList;
import java.util.List;

public class arenaModel {

    private int width;
    private int height;

    private List<bulletModel> activeBullets;
    private List<wallModel> walls;
    private playerModel player;

    arenaModel(int x, int y){
        this.width = width;
        this.height = height;
        this.player = new playerModel(new positionModel(10,height-2),3);
        this.activeBullets = new ArrayList<>();
        walls = com.Carlos.spaceinvanders.Entities.Builders.Builders.
    }


    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }
}
