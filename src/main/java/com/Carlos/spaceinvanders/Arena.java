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
    private Bullets bullet;
    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.player = new Player(10,height - 2);
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

    public void drawArena(TextGraphics graphics){
        player.Draw(graphics);
        drawOutline(graphics);
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

    public void drawBullet(TextGraphics graphics, Screen screen)throws IOException {
        this.bullet = new Bullets(player.getPosition(), 1);
        while (true) {
            bullet.move();
            bullet.isActive();
            System.out.println(bullet.getPosition().getY());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            graphics.enableModifiers(SGR.BOLD);
            screen.clear();
            graphics.putString(new TerminalPosition(bullet.getPosition().getX(), bullet.getPosition().getY()), "|");
            drawArena(graphics);
            screen.refresh();

            if (bullet.active == false) {
                break;
            }
        }
    }
}