package com.Carlos.spaceinvaders.model.models;

public abstract class Elements implements Model{
    
    protected PositionModel position; // All the subclasses will have a Position position
    
    public Elements(PositionModel position){
        this.position = position;
    }
    
    public PositionModel getPosition() {
        return position;
    }

    public void setPosition(PositionModel position) {
        this.position = position;
    }
}
