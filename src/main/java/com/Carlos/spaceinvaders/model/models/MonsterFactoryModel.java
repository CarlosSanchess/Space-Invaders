package com.Carlos.spaceinvaders.model.models;

public class MonsterFactoryModel {

    private long Delay;
    private int numMonstros;
    public MonsterFactoryModel(){
        this.Delay = 3000;
        this.numMonstros = 1;
    }

    public long getDelay() {
        return Delay;
    }

    public void setDelay(long delay) {
        this.Delay = delay;
    }

    public int getNumMonstros() {
        return numMonstros;
    }
}
