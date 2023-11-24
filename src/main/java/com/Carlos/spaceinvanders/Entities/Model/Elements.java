package com.Carlos.spaceinvanders.Entities.Model;

public abstract class Elements implements Model{
    
    protected PositionModel position; // All the subclasses will have a Position position
    
    Elements(PositionModel position){
        this.position = position;
    }
    
    public PositionModel getPosition() {
        return position;
    }

    public void setPosition(PositionModel position) {
        this.position = position;
    }
}
