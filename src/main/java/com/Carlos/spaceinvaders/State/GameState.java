package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.game.GameController;
import com.Carlos.spaceinvaders.controller.game.MonsterControllerFactory;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.ArenaModel;
import com.Carlos.spaceinvaders.view.game.DrawGame;

import java.io.IOException;

public class GameState extends State<ArenaModel> {

    private DrawGame drawGame;
    private GameController gameController;
    private MonsterControllerFactory monsterControllerFactory;

    public GameState(ArenaModel arenaModel){
        super(arenaModel);
        this.drawGame = new DrawGame(getModel());
        this.gameController = new GameController(getModel());
    }


    @Override
    public void step(String Key, LanternaGui GUI, long Time,Game game) throws IOException {
        drawGame.lanternaDraw(GUI);
        gameController.toDo(game,Key,Time);
    }
}