package com.Carlos.spaceinvanders.Entities;
import com.Carlos.spaceinvanders.Entities.Builders.Builders;
import com.Carlos.spaceinvanders.Entities.Builders.createMonsters;

import com.Carlos.spaceinvanders.UI.drawOutline;
import com.Carlos.spaceinvanders.UI.drawPlayer;
import com.Carlos.spaceinvanders.UI.drawBullets;
import com.Carlos.spaceinvanders.UI.drawMonster;
import com.Carlos.spaceinvanders.UI.drawArena;
import com.Carlos.spaceinvanders.UI.drawMonsters;


import com.googlecode.lanterna.input.KeyStroke;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//If active bullets Draw bullets, mover player
//ELse mover player apenas
public class arenaModel {

    private final int width;
    private final int height;

    private List<bulletModel> activeBullets;
    private List<wallModel> walls;
    private List<monsterModel> activeMonsters;
    private createMonsters createMonsters;

    private playerModel player;
    private monsterModel monsterModel;

    public drawPlayer drawPlayer;
    public drawBullets drawBullets;
    public drawOutline drawOutline;

    private drawMonsters drawMonsters;

    //TODO
    //É safe os objetos de draw serem publicos?
    public arenaModel(int x, int y) throws InterruptedException {
        this.width = x;
        this.height = y;
        this.player = new playerModel(new positionModel(10,y - 2),3);
        this.activeBullets = new ArrayList<>();
        this.createMonsters = new createMonsters(x); // OPT 1

        walls = Builders.createWalls(width,height);// OPT 2
        activeMonsters = createMonsters.addMonsters(3);
        System.out.println(activeMonsters);

        drawMonsters = new drawMonsters(this.activeMonsters);
        drawOutline = new drawOutline(this.walls);
        drawPlayer = new drawPlayer(this.player);

    }

    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }

    public playerModel getPlayer() {
        return this.player;
    }

    public drawArena getDrawArena(){ // Retorna a arena
        return new drawArena(this);
    }
    public arenaModel getArenaModel(){
        return this;
    }

    public com.Carlos.spaceinvanders.UI.drawBullets getDrawBullets() {
        return drawBullets;
    }

    public com.Carlos.spaceinvanders.UI.drawOutline getDrawOutline() {
        return drawOutline;
    }

    public com.Carlos.spaceinvanders.UI.drawPlayer getDrawPlayer() {
        return drawPlayer;
    }

    public List<bulletModel> getActiveBullets() {
        return activeBullets;
    }

    public com.Carlos.spaceinvanders.UI.drawMonsters getDrawMonsters() {
        return drawMonsters;
    }


    //Tirar daqui o processKey, dar get na arena e mover a partir dai

    /*
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

     */
}
