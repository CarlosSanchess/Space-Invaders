package com.Carlos.spaceinvaders.controller.game.MonstersStrategy;

import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

import java.util.Random;

public class DiagonalMovementStrategy implements MovementStrategy {
    private static final int SWITCH_PROBABILITY = 20;
    private int xDirection; // 1 direita, -1 esquerda
    private int arenaW;
    private Random random = new Random();

    public DiagonalMovementStrategy(int arenaW) {
        this.arenaW = arenaW;
        this.xDirection = random.nextBoolean() ? 1 : -1;
    }

    private boolean canMove(int wantedX){
        return wantedX <= arenaW - 1 && wantedX >= 1;
    }

    @Override
    public void move(MonsterModel monster) {
        PositionModel currentPosition = monster.getPosition();
            int wantedX = currentPosition.getX() + xDirection * monster.getSpeed();
            if (canMove(wantedX)) {
                currentPosition.setX(wantedX);
                currentPosition.setY(currentPosition.getY() + monster.getSpeed());

                if (random.nextInt(100) < SWITCH_PROBABILITY) {
                    xDirection *= -1;
                } else if (currentPosition.getX() <= 0 || currentPosition.getX() >= arenaW) {
                    xDirection *= -1;
                }
                monster.setPosition(currentPosition);
            }
    }
}