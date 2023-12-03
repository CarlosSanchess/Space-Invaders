package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.BulletModel;

import java.util.List;
import java.util.Random;

public class ShooterMovementStrategy implements MovementStrategy {
    private int xDirection = 1; // 1 direita, -1 esquerda
    private int arenaW;
    private Random random = new Random();
    List<BulletModel> bullets;

    public ShooterMovementStrategy(int arenaW, List<BulletModel> bullets) {
        this.arenaW = arenaW;
        this.xDirection = random.nextBoolean() ? 1 : -1;
        this.bullets = bullets;
    }

    private boolean canMove(int wantedX){
        return wantedX < arenaW - 1 && wantedX > 0;
    }

    @Override
    public void move(MonsterModel monster) {
       boolean aux = random.nextBoolean();
       if(aux){
           moveMonster(monster);
       }else{
           shootMonster(monster);
       }
    }

    private void moveMonster(MonsterModel monster){
            PositionModel currentPosition = monster.getPosition();

            int wantedX = currentPosition.getX() + xDirection * monster.getSpeed();
            currentPosition.setX(wantedX);

            if (currentPosition.getX() <= 0 || currentPosition.getX() >= arenaW - 1) {
                xDirection *= -1;
                currentPosition.setX(currentPosition.getX() + xDirection * monster.getSpeed());
            }

            if (canMove(currentPosition.getX())) {
                monster.setPosition(currentPosition);
            }
    }
    public void shootMonster(MonsterModel model) {
            bullets.add(newBullet(model));
    }
    public BulletModel newBullet(MonsterModel monster){
        PositionModel monsterPosition = monster.getPosition();

        return new BulletModel( new PositionModel(monsterPosition.getX(), monsterPosition.getY()),1, false);
    }
}