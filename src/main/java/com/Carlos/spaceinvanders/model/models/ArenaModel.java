package com.Carlos.spaceinvanders.model.models;

import com.Carlos.spaceinvanders.model.builders.CreateWalls;
import com.Carlos.spaceinvanders.model.builders.CreateMonsters;


import java.util.ArrayList;
import java.util.List;


public class ArenaModel implements Model {


    private final int width;
    private final int height;

    private List<BulletModel> activeBullets;
    private List<WallModel> walls;
    private List<MonsterModel> activeMonsters;
    private CreateMonsters createMonsters;
    private ScoreModel score;

    private PlayerModel player;

    public ArenaModel(int x, int y) throws InterruptedException {
        this.width = x;
        this.height = y;

        this.player = new PlayerModel(new PositionModel(78, y - 2), 3);
        this.score = new ScoreModel(new PositionModel(77, y - 3)); // EXprimental position

        this.activeBullets = new ArrayList<>();
        this.createMonsters = new CreateMonsters(x);

        walls = CreateWalls.createWalls(x, y);
        activeMonsters = createMonsters.addMonsters(3);
        activeBullets.add(new BulletModel(new PositionModel(40, y - 3), 1, true));
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

    public List<BulletModel> getActiveBullets() {
        return activeBullets;
    }

    public List<MonsterModel> getActiveMonsters() {
        return activeMonsters;
    }

    public List<WallModel> getWalls() {
        return walls;
    }

    public ScoreModel getScore() {
        return score;
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
