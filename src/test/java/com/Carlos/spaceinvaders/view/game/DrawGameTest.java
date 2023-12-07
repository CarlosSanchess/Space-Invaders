package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

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

        PlayerModel playerModel = Mockito.mock(PlayerModel.class);
        Mockito.when(playerModel.getPosition()).thenReturn(position);
        Mockito.when(arenaModel.getPlayer()).thenReturn(playerModel);

        gui = Mockito.mock(LanternaGui.class);
        drawGame = new DrawGame(arenaModel);
    }

    
    @Test
    public void testDraw() {
        LanternaGui gui = Mockito.mock(LanternaGui.class);
        
        DrawPlayer drawPlayer = Mockito.mock(DrawPlayer.class);
        DrawMonsters drawMonsters = Mockito.mock(DrawMonsters.class);
        DrawBullets drawBullets = Mockito.mock(DrawBullets.class);
        DrawOutline drawOutline = Mockito.mock(DrawOutline.class);
        DrawScore drawScore = Mockito.mock(DrawScore.class);
        DrawPowerUps drawPowerUps = Mockito.mock(DrawPowerUps.class);
        
        Mockito.when(drawPlayer.getModel()).thenReturn(Mockito.mock(PlayerModel.class));
        Mockito.when(drawMonsters.getModel()).thenReturn(Mockito.mock(List.class));
        Mockito.when(drawBullets.getModel()).thenReturn(Mockito.mock(List.class));
        Mockito.when(drawOutline.getModel()).thenReturn(Mockito.mock(List.class));
        Mockito.when(drawScore.getModel()).thenReturn(Mockito.mock(ScoreModel.class));
        Mockito.when(drawPowerUps.getModel()).thenReturn(Mockito.mock(List.class));
        
        DrawGame drawGame = new DrawGame(Mockito.mock(ArenaModel.class));
        drawGame.drawElement(drawPlayer, gui);
        drawGame.drawElement(drawMonsters, gui);
        drawGame.drawElement(drawBullets, gui);
        drawGame.drawElement(drawOutline, gui);
        drawGame.drawElement(drawScore, gui);
        drawGame.drawElement(drawPowerUps, gui);
        
        verify(drawPlayer).draw(gui);
        verify(drawMonsters).draw(gui);
        verify(drawBullets).draw(gui);
        verify(drawOutline).draw(gui);
        verify(drawScore).draw(gui);
        verify(drawPowerUps).draw(gui);
    }

    @Test
    public void testDrawPlayer() {
        PlayerModel playerModel = Mockito.mock(PlayerModel.class);
        DrawPlayer drawPlayer = Mockito.mock(DrawPlayer.class);
        Mockito.when(drawPlayer.getModel()).thenReturn(playerModel);

        drawGame.drawElement(drawPlayer, gui);

        verify(drawPlayer).draw(gui);
    }

    @Test
    public void testDrawMonsters() {
        List<MonsterModel> mockMonsters = Mockito.mock(List.class);
        Mockito.when(arenaModel.getActiveMonsters()).thenReturn(mockMonsters);

        DrawMonsters drawMonsters = Mockito.mock(DrawMonsters.class);
        Mockito.when(drawMonsters.getModel()).thenReturn(mockMonsters);

        drawGame.drawElement(drawMonsters, gui);

        verify(drawMonsters).draw(gui);
    }

    @Test
    public void testDrawBullets() {
        List<BulletModel> mockBullets = Mockito.mock(List.class);
        Mockito.when(arenaModel.getActiveBullets()).thenReturn(mockBullets);

        DrawBullets drawBullets = Mockito.mock(DrawBullets.class);
        Mockito.when(drawBullets.getModel()).thenReturn(mockBullets);

        drawGame.drawElement(drawBullets, gui);

        verify(drawBullets).draw(gui);
    }

    @Test
    public void testDrawOutline() {
        List<WallModel> mockWalls = Mockito.mock(List.class);
        Mockito.when(arenaModel.getWalls()).thenReturn(mockWalls);

        DrawOutline drawOutline = Mockito.mock(DrawOutline.class);
        Mockito.when(drawOutline.getModel()).thenReturn(mockWalls);

        drawGame.drawElement(drawOutline, gui);

        verify(drawOutline).draw(gui);
    }
    
    @Test
    public void testDrawScore() {
        ScoreModel mockScore = Mockito.mock(ScoreModel.class);
        Mockito.when(arenaModel.getScore()).thenReturn(mockScore);

        DrawScore drawScore = Mockito.mock(DrawScore.class);
        Mockito.when(drawScore.getModel()).thenReturn(mockScore);

        drawGame.drawElement(drawScore, gui);

        verify(drawScore).draw(gui);
    }

    @Test
    public void testDrawPowerUps() {
        List<PowerUp> mockPowerUps = Mockito.mock(List.class);
        Mockito.when(arenaModel.getActivePowerUps()).thenReturn(mockPowerUps);

        DrawPowerUps drawPowerUps = Mockito.mock(DrawPowerUps.class);
        Mockito.when(drawPowerUps.getModel()).thenReturn(mockPowerUps);

        drawGame.drawElement(drawPowerUps, gui);

        verify(drawPowerUps).draw(gui);
    }
}