package com.Carlos.spaceinvaders.model.models;
import com.Carlos.spaceinvanders.model.models.BulletModel;
import com.Carlos.spaceinvanders.model.models.PlayerModel;
import com.Carlos.spaceinvanders.model.models.PositionModel;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;



public class PlayerTest {

    @Test
    public void testPlayerShoot() {
        PositionModel position = new PositionModel(0, 1); 
        PlayerModel player = new PlayerModel(position, 3);

        BulletModel bullet = player.playerShoot();

        assertNotNull(bullet);
        assertEquals(position.getX(), bullet.getPosition().getX());
        assertEquals(position.getY(), bullet.getPosition().getY());
        assertTrue(bullet.isActive());
    }

    @Test
    public void testCanMoveWithinScreenBounds() {
        PositionModel initialPosition = new PositionModel(0, 0);
        PlayerModel player = new PlayerModel(initialPosition, 100); //hitpoints valor exemplo
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        for (int x = 1; x < screenSize.width - 1; x++) {
            PositionModel position = new PositionModel(x, 0);
            assertTrue(player.canMove(position));
        }
    }

    @Test
    public void testCannotMoveOutsideScreenBounds() {
        PositionModel initialPosition = new PositionModel(0, 0);
        PlayerModel player = new PlayerModel(initialPosition, 100);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        PositionModel position1 = new PositionModel(-1, 0);
        assertFalse(player.canMove(position1));
        PositionModel position2 = new PositionModel(screenSize.width, 0);
        assertFalse(player.canMove(position2));
    }

    @Test
    public void testMoveLeft() {
        PositionModel position = new PositionModel(5, 0);
        PlayerModel player = new PlayerModel(position, 3);

        player.moveLeft(position);

        assertEquals(4, position.getX());
    }

    @Test
    public void testMoveRight() {
        PositionModel position = new PositionModel(5, 0);
        PlayerModel player = new PlayerModel(position, 3);

        player.moveRight(position);

        assertEquals(6, position.getX());
    }
}
