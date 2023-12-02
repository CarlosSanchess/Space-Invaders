package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterModel;

public interface MovementStrategy {
    public void move(MonsterModel monsterModel);
}
