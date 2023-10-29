package com.Carlos.spaceinvanders;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Arena {

    private int width;
    private int height;

    private Player player;
    private List<Bullet> activeBullets;
    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.player = new Player(10,height - 2);
        this.activeBullets = new ArrayList<>();

    }


    public void moveRight(){
        Position p  = player.getPosition();
        if (canMove(p,1)){
            player.setPosition(p.getX() + 1);
        }
    }
    public void moveLeft(){
        Position p  = player.getPosition();
        if (canMove(p, -1)){
            player.setPosition(p.getX() - 1);
        }
    }
    public boolean canMove(Position p, int x) { // Dar fix fazer com que receba a posição futura
        if (p.getX() + x < 1 || p.getX() + x  == width - 1) {
            return false;
        }
        return true;
    }

    public void drawArena(TextGraphics graphics) throws IOException {
        player.Draw(graphics);
        drawOutline(graphics);
        drawBullets(graphics);
    }
    public void drawOutline(TextGraphics graphics){ //
        for (Wall wall : createWalls()){
            wall.wallDraw(graphics);
        }
    }
    private List<Wall> createWalls(){ // Codigo do hero
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    public void drawBullets(TextGraphics graphics)throws IOException {
        //Correr a lista das bullets
        //Mover a bullet
        // desenhar a bullet com o Bullet.draw
        if(!activeBullets.isEmpty() ){
            for(Bullet bullet:activeBullets) {
                bullet.move();
                bullet.isActive();
                if (!bullet.isActive()) {
                    activeBullets.remove(bullet);
                    break;
                }
                bullet.draw(graphics);
            }
        }
    }

    public void addBullet() {
        activeBullets.add(new Bullet(player.getPosition(),1,true));
    }

}