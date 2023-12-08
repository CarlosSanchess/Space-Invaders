package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.State.GameOverMenuState;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.model.models.PlayerModel;
import com.Carlos.spaceinvaders.model.models.ScoreModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class GameControllerTest {
    private GameController gameController;
    private PlayerModel playerModel;
    private ScoreModel scoreModel;
    private Game game;

    @BeforeEach
    public void setUp() {
        ArenaModel arenaModel = Mockito.mock(ArenaModel.class);
        playerModel = Mockito.mock(PlayerModel.class);
        scoreModel = Mockito.mock(ScoreModel.class);
        game = Mockito.mock(Game.class);
        gameController = new GameController(arenaModel);
        gameController.getModel().setPlayer(playerModel);
        gameController.getModel().setScore(scoreModel);
    }

    @Test
    public void testToDo_EndGame_PlayerHitPointsZero() {
        when(playerModel.getHitPoints()).thenReturn(0);

        gameController.toDo(game, null, 0);

        verify(gameController.getSoundController(), times(1)).playSound("GameOver");
        verify(game, times(1)).popState();
        verify(game, times(1)).pushState(any(GameOverMenuState.class));
        verify(scoreModel, never()).getScore();
        verify(scoreModel, never()).setScore(anyInt());
    }

    @Test
    public void testToDo_EndGame_PlayerHitPointsGreaterThanZero() {
        when(playerModel.getHitPoints()).thenReturn(1);

        gameController.toDo(game, null, 0);

        verify(gameController.getSoundController(), never()).playSound("GameOver");
        verify(game, never()).popState();
        verify(game, never()).pushState(any(GameOverMenuState.class));
        verify(scoreModel, never()).getScore();
        verify(scoreModel, never()).setScore(anyInt());
    }

    @Test
    public void testToDo_PowerUpFactoryCreatePowerUp() {
        gameController.toDo(game, null, 0);

        verify(gameController.getPowerUpFactory(), times(1)).createPowerUp(anyLong(), anyInt());
    }

    @Test
    public void testToDo_MonsterControllerFactoryCreateMonstersAndControllers() {
        gameController.toDo(game, null, 0);

        verify(gameController.getMonsterControllerFactory(), times(1)).CreateMonstersAndControllers(anyLong());
    }

    @Test
    public void testToDo_PlayerControllerToDo() {
        gameController.toDo(game, "keyPressed", 0);

        verify(gameController.getPlayerController(), times(1)).toDo(eq(game), eq("keyPressed"), anyLong());
    }

    @Test
    public void testToDo_BulletsControllerToDo() {
        gameController.toDo(game, "keyPressed", 0);

        verify(gameController.getBulletsController(), times(1)).toDo(eq(game), eq("keyPressed"), anyLong());
    }

    @Test
    public void testToDo_PowerUpControllerToDo() {
        gameController.toDo(game, "keyPressed", 0);

        verify(gameController.getPowerUpController(), times(1)).toDo(eq(game), eq("keyPressed"), anyLong());
    }

    @Test
    public void testToDo_MonsterControllerToDo() {
        MonsterController monsterController = Mockito.mock(MonsterController.class);
        when(gameController.getMonsterControllerFactory().getMonstersControllers()).thenReturn(List.of(new MonsterController[]{monsterController}));

        gameController.toDo(game, null, 0);

        verify(monsterController, times(1)).toDo(eq(game), eq(null), anyLong());
    }

    @Test
    public void testEndGame_PlayerHitPointsZero() {
        when(playerModel.getHitPoints()).thenReturn(0);
        when(scoreModel.getScore()).thenReturn(100);
        when(scoreModel.getHighScore()).thenReturn(50);

        gameController.endGame(game);

        verify(gameController.getSoundController(), times(1)).playSound("GameOver");
        verify(game, times(1)).popState();
        verify(game, times(1)).pushState(any(GameOverMenuState.class));
        verify(scoreModel, times(1)).getScore();
        verify(scoreModel, times(1)).setScore(eq(100));
        verify(scoreModel, times(1)).getHighScore();
        verify(scoreModel, times(1)).setHighScore(eq(100));
    }

    @Test
    public void testEndGame_PlayerHitPointsGreaterThanZero() {
        when(playerModel.getHitPoints()).thenReturn(1);

        gameController.endGame(game);

        verify(gameController.getSoundController(), never()).playSound("GameOver");
        verify(game, never()).popState();
        verify(game, never()).pushState(any(GameOverMenuState.class));
        verify(scoreModel, never()).getScore();
        verify(scoreModel, never()).setScore(anyInt());
        verify(scoreModel, never()).getHighScore();
        verify(scoreModel, never()).setHighScore(anyInt());
    }
}