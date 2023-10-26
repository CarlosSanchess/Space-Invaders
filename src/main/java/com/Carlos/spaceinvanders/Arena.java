package com.Carlos.spaceinvanders;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {

    private int width;
    private int height;

    private Player player;
    private Bullets bullet;
    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.player = new Player(10,height - 1);
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
        if (p.getX() + x < 0 || p.getX() + x  == width) {
            return false;
        }
        return true;
    }

    public void Draw(TextGraphics graphics){
        player.Draw(graphics);
    }


    public void drawBullet(TextGraphics graphics, Screen screen)throws IOException {
        this.bullet = new Bullets(player.getPosition(), 1);
        while (true) {
            int y = bullet.move();
            bullet.isActive(y);
            System.out.println(bullet.getPosition().getY());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            graphics.enableModifiers(SGR.BOLD);
            screen.clear();
            graphics.putString(new TerminalPosition(bullet.getPosition().getX(), bullet.getPosition().getY()), "|");
            Draw(graphics);
            screen.refresh();

            if (bullet.active == false) {
                break;
            }
        }
    }
}
