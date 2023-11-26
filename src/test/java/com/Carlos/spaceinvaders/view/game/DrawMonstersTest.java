package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class DrawMonstersTest {

    @Mock
    private LanternaGui mockGui;

    private DrawMonsters drawMonsters;
    private List<MonsterModel> monsters;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        monsters = new ArrayList<>();
        drawMonsters = new DrawMonsters(monsters);
    }

    @Test
    void testDraw() {
        PositionModel position1 = new PositionModel(1, 1);
        MonsterModel monster1 = new MonsterModel(position1, 10, 5);

        PositionModel position2 = new PositionModel(2, 2);
        MonsterModel monster2 = new MonsterModel(position2, 20, 3);

        monsters.add(monster1);
        monsters.add(monster2);

        drawMonsters.draw(mockGui);

        verify(mockGui, times(2)).drawText(any(PositionModel.class), any(String.class), any(TextColor.RGB.class));    
    }
}