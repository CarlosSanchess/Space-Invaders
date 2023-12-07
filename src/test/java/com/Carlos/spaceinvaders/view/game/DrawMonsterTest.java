package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import org.junit.jupiter.api.Test;

import com.googlecode.lanterna.TextColor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DrawMonsterTest {

    @Test
    public void testDraw() {
        LanternaGui guiMock = mock(LanternaGui.class);

        MonsterModel monsterModel = new MonsterModel(new PositionModel(1,1), 10, 10);

        DrawMonster drawMonster = new DrawMonster(monsterModel);

        drawMonster.draw(guiMock);

        verify(guiMock).drawText(monsterModel.getPosition(), "]", new TextColor.RGB(255, 0, 0));
    }

    @Test
    public void testGetModel() {
        MonsterModel monsterModel = new MonsterModel(new PositionModel(1,1), 10, 10);
        DrawMonster drawMonster = new DrawMonster(monsterModel);

        MonsterModel result = drawMonster.getModel();

        assertEquals(monsterModel, result);
    }
}
