package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DrawMonsterTest {

    @Test
    public void testDraw() {
        LanternaGui guiMock = mock(LanternaGui.class);

        MonsterModel monsterModel = new MonsterModel(new PositionModel(1,1), 10, 10);

        DrawMonster drawMonster = new DrawMonster(monsterModel);

        drawMonster.draw(guiMock);

        verify(guiMock).drawText(monsterModel.getPosition(), "]", new TextColor.RGB(255, 0, 0));
    }
}
