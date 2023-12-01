package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;

import java.util.Random;

public class DiagonalMovementStrategy implements MovementStrategy {
    private int xDirection; // 1 direita, -1 esquerda
    private int arenaW;
    private Random random = new Random();

    public DiagonalMovementStrategy(int arenaW) {
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
        if (canMove(wantedX)) {
            currentPosition.setX(wantedX);
            currentPosition.setY(currentPosition.getY() + monster.getSpeed());

            if (currentPosition.getX() <= 0 || currentPosition.getX() >= arenaW) {
                xDirection *= -1; // inverte a direção no eixo dos x
            }

            monster.setPosition(currentPosition);
        }
    }
}