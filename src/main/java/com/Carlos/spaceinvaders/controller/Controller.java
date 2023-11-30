package com.Carlos.spaceinvaders.controller;

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
