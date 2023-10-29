package com.Carlos.spaceinvanders.Entities;

public abstract class Elements {
    protected positionModel position; // All the subclasses will have a Position position
    Elements(positionModel position){
        this.position = position;
    }
    public positionModel getPosition() {
        return position;
    }
}
