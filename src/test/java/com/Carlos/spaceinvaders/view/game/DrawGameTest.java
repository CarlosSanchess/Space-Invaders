package com.Carlos.spaceinvaders.view.game;
import com.Carlos.spaceinvanders.gui.LanternaGui;
import com.Carlos.spaceinvanders.model.models.ArenaModel;
import com.Carlos.spaceinvanders.model.models.PositionModel;
import com.Carlos.spaceinvanders.model.models.ScoreModel;
import com.Carlos.spaceinvanders.view.game.DrawGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

public class DrawGameTest {

    private DrawGame drawGame;
    private ArenaModel arenaModel;
    private LanternaGui gui;

    @BeforeEach
    public void setUp() {
        arenaModel = Mockito.mock(ArenaModel.class);
        PositionModel position = new PositionModel(0, 0);
        ScoreModel scoreModel = new ScoreModel(position);
        Mockito.when(arenaModel.getScore()).thenReturn(scoreModel);
        gui = Mockito.mock(LanternaGui.class);
        drawGame = new DrawGame(arenaModel);
}

    @Test
    public void testDraw() {
        drawGame.draw(gui);

        verify(arenaModel).getActiveMonsters();
        verify(arenaModel).getActiveBullets();
        verify(arenaModel).getWalls();
        verify(arenaModel).getScore();
    }
}
