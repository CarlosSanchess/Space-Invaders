package com.Carlos.spaceinvaders.controller;

import com.Carlos.spaceinvaders.model.models.ArenaModel;

public abstract class Controller <T> { //Mesma implementação do Viewer

    private final T model;
    public Controller(T model){
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void toDo(String keyPressed);



}
