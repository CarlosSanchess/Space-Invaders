package com.Carlos.spaceinvanders.Entities;

public abstract class Elements {
    protected PositionModel position; // All the subclasses will have a Position position
    Elements(PositionModel position){
        this.position = position;
    }
    public PositionModel getPosition() {
        return position;
    }
}
