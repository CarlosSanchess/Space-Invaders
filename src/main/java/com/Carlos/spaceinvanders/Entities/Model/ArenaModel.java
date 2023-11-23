package com.Carlos.spaceinvanders.Entities.Model;

import com.Carlos.spaceinvanders.Entities.Builders.Builders;
import com.Carlos.spaceinvanders.Entities.Builders.createMonsters;
import com.Carlos.spaceinvanders.UI.View.DrawArena;
import com.Carlos.spaceinvanders.UI.View.DrawBullets;
import com.Carlos.spaceinvanders.UI.View.DrawMonsters;
import com.Carlos.spaceinvanders.UI.View.DrawOutline;
import com.Carlos.spaceinvanders.UI.View.DrawPlayer;

import java.util.ArrayList;
import java.util.List;

public class ArenaModel {

    private final int width;
    private final int height;

    private List<BulletModel> activeBullets;
    private List<WallModel> walls;
    private List<MonsterModel> activeMonsters;
    private createMonsters createMonsters;

    private PlayerModel player;
    private MonsterModel monsterModel;

    public DrawPlayer drawPlayer;
    public DrawBullets drawBullets;
    public DrawOutline drawOutline;

    private DrawMonsters drawMonsters;

    public ArenaModel(int x, int y) throws InterruptedException {
        this.width = x;
        this.height = y;
        this.player = new PlayerModel(new PositionModel(10, y - 2), 3);
        this.activeBullets = new ArrayList<>();
        this.createMonsters = new createMonsters(x);

        walls = Builders.createWalls(width, height);
        activeMonsters = createMonsters.addMonsters(3);

        drawMonsters = new DrawMonsters(this.activeMonsters);
        drawOutline = new DrawOutline(this.walls);
        drawPlayer = new DrawPlayer(this.player);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PlayerModel getPlayer() {
        return this.player;
    }

    public DrawArena getDrawArena() {
        return new DrawArena(this);
    }

    public ArenaModel getArenaModel() {
        return this;
    }

    public DrawBullets getDrawBullets() {
        return drawBullets;
    }

    public DrawOutline getDrawOutline() {
        return drawOutline;
    }

    public DrawPlayer getDrawPlayer() {
        return drawPlayer;
    }

    public List<BulletModel> getActiveBullets() {
        return activeBullets;
    }

    public DrawMonsters getDrawMonsters() {
        return drawMonsters;
    }
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
