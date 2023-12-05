package com.Carlos.spaceinvaders.model.models.PowerUp;

import com.Carlos.spaceinvaders.controller.game.Buffs.Buff;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.Elements;
import com.Carlos.spaceinvaders.model.models.PositionModel;

public class PowerUp extends Elements {

    long upTime;
    PositionModel position;
    private final int speed;
    boolean active;
    public PowerUp(PositionModel position, int speed, long upTime, boolean active){
        super(position);
        this.speed = speed;
        this.upTime = upTime;
        this.active = true;
    }
    public void move() {
            position.setY(position.getY() + speed);
    }
}
