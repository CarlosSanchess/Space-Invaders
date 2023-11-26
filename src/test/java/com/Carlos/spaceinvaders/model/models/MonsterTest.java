package com.Carlos.spaceinvaders.model.models;
import com.Carlos.spaceinvanders.model.models.MonsterModel;
import com.Carlos.spaceinvanders.model.models.PositionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MonsterTest {
    private MonsterModel monster;

    @BeforeEach
    public void setUp() {
        PositionModel position = new PositionModel(0, 0);
        int hitPoints = 10; 
        int speed = 5; 
        monster = new MonsterModel(position, hitPoints, speed);
    }

    @Test
    public void testMove() {
        monster.move();
        assertEquals(5, monster.getPosition().getY());

        monster.setDirection(true);
        monster.move();
        assertEquals(0, monster.getPosition().getY());
    }
}
