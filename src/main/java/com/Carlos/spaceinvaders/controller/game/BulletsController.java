package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.model.models.BulletModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.Viewer;

import java.util.List;

public class BulletsController extends Controller<List<BulletModel>> {

    public BulletsController(List<BulletModel> bullets){
        super(bullets);
    }
    @Override
    public void toDo(String keyPressed) {
        for(BulletModel bullet : super.getModel()){
            System.out.println("adssad");
                move(bullet);
        }
    }

    public void move(BulletModel bullet){
        if(bullet.getDirection())
            bullet.getPosition().setY(bullet.getPosition().getY() - bullet.getSpeed());
        else
            bullet.getPosition().setY(bullet.getPosition().getY() + bullet.getSpeed());
        bullet.isActive();
    }

}
