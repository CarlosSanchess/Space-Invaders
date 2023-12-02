package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.model.models.BulletModel;

import java.util.Random;

public class ShooterMovementStrategy implements MovementStrategy {
    private int xDirection = 1; // 1 direita, -1 esquerda
    private int arenaW;
    private Random random = new Random();


    public ShooterMovementStrategy(int arenaW) {
        this.arenaW = arenaW;
        this.xDirection = random.nextBoolean() ? 1 : -1;
    }

    private boolean canMove(int wantedX){
        return wantedX < arenaW - 1 && wantedX > 0;
    }

    @Override
    public void move(MonsterModel monster) {
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

    public BulletModel shoot(MonsterModel monster) {
        PositionModel currentPosition = monster.getPosition();
        PositionModel bulletPosition = new PositionModel(currentPosition.getX(), currentPosition.getY() + 1);
        BulletModel bullet = new BulletModel(bulletPosition, -1, true);
        return bullet;
    }
}