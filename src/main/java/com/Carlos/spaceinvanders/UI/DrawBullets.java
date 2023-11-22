package com.Carlos.spaceinvanders.UI;

import com.Carlos.spaceinvanders.Entities.BulletModel;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.util.Iterator;
import java.util.List;

public class DrawBullets implements DrawEntities {
    List<BulletModel> activeBullets;
    public DrawBullets(List<BulletModel> activeBullets){
        this.activeBullets = activeBullets;
    }

    @Override
    public void draw(TextGraphics graphics) {
        // + EFI
        Iterator<BulletModel> iterator = activeBullets.iterator();

        while (iterator.hasNext()) {
            BulletModel bullet = iterator.next();
            bullet.move();
            if (!bullet.isActive()) {
                iterator.remove(); // Remove inactive bullet
            } else {
                DrawBullet bulletDraw = new DrawBullet(bullet);
                bulletDraw.draw(graphics);
            }
        }
    /*
        if(activeBullets.isEmpty() == false) {
            for (bulletModel bullet : activeBullets) {
                bullet.move();
                bullet.isActive();
                if (!bullet.isActive()) {
                    activeBullets.remove(bullet);
                    System.out.println("asdsa");
                } else {
                    drawBullet drawBullet = new drawBullet(bullet);
                    drawBullet.draw(graphics);
                }
            }
        }
    }
    */
    }
}
