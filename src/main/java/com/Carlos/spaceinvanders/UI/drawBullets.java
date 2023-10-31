package com.Carlos.spaceinvanders.UI;

import com.Carlos.spaceinvanders.Entities.bulletModel;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.util.List;

public class drawBullets implements drawEntities {
    List<bulletModel> activeBullets;
    public drawBullets(List<bulletModel> activeBullets){
        this.activeBullets = activeBullets;
    }

    @Override
    public void draw(TextGraphics graphics){  //COdigo GPT
        /*
        Iterator<bulletModel> iterator = activeBullets.iterator();

        while (iterator.hasNext()) {
            bulletModel bullet = iterator.next();
            bullet.move();
            if (!bullet.isActive()) {
                iterator.remove(); // Remove inactive bullet
            } else {
                drawBullet bulletDraw = new drawBullet(bullet);
                bulletDraw.draw(graphics);
            }
        }
    */
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
}
