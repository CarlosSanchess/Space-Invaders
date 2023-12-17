/*

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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DrawMonstersTest{
    @Mock
    private LanternaGui guiMock;

    private DrawMonsters drawMonsters;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        List<MonsterModel> monsters = new ArrayList<>();
        PositionModel position1 = new PositionModel(41, 1);
        MonsterModel monster1 = new MonsterModel(position1, 1, 1);

        PositionModel position2 = new PositionModel(40, 1);
        MonsterModel monster2 = new MonsterModel(position2, 1, 1);
        monsters.add(monster1);
        monsters.add(monster2);
        drawMonsters = new DrawMonsters(monsters);
    }

    @Test
    public void testDraw() {

        drawMonsters.draw(guiMock);

        verify(guiMock, times(2)).drawText(any(PositionModel.class), any(String.class), any(TextColor.RGB.class));
    }

}

 */