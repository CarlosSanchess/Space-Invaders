package com.Carlos.spaceinvanders.Entities;
import com.Carlos.spaceinvanders.Entities.Builders.Builders;
import com.Carlos.spaceinvanders.UI.drawBullet;
import com.Carlos.spaceinvanders.UI.drawOutline;
import com.Carlos.spaceinvanders.UI.drawPlayer;
import com.Carlos.spaceinvanders.UI.drawBullets;
import com.Carlos.spaceinvanders.UI.drawMonster;
import com.Carlos.spaceinvanders.Entities.Builders.getRandomPosM;

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
    private List<monsterModel> activeMonsters;

    private playerModel player;
    private monsterModel monsterModel;

    private drawPlayer drawPlayer;
    private drawBullets drawBullets;
    private drawOutline drawOutline;
    private drawMonster drawMonster;


    public arenaModel(int x, int y){
        this.width = x;
        this.height = y;
        this.player = new playerModel(new positionModel(10,y - 2),3);
        this.activeBullets = new ArrayList<>();
        walls = Builders.createWalls(width,height);

        drawOutline = new drawOutline(walls);
        drawPlayer = new drawPlayer(this.player);
        //Testar Monters
       // monsterModel = new monsterModel(getRandomPosM.positionModel(),1,1);
       // drawMonster = new drawMonster(monsterModel);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }


   public void Draw(TextGraphics graphics) throws IOException { // Da draw no player e na outline
       drawPlayer.draw(graphics);
       drawOutline.draw(graphics);
      //  drawMonster.draw(graphics);
       if (!activeBullets.isEmpty()) {
           drawBullets = new drawBullets(activeBullets);
           drawBullets.draw(graphics);
       }
   }

    public void processKey(KeyStroke key) throws IOException, InterruptedException { // Aqui ou no controls package ou no game

            switch (key.getKeyType()) {
                case ArrowLeft:
                    player.moveLeft(player.getPosition());
                    break;
                case ArrowRight:
                    player.moveRight(player.getPosition());
                    break;
                case Backspace: //ADD CANSHOOT? nerfar a arma, possivle
                    activeBullets.add(this.player.playerShoot()); //Ok
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
