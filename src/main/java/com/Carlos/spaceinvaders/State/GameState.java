package com.Carlos.spaceinvaders.State;

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
        monsterControllerFactory = new MonsterControllerFactory(super.getModel().getWidth());
    }


    @Override
    public void step(String Key, LanternaGui GUI) throws IOException {
        this.drawGame = new DrawGame(super.getModel());

        this.gameController = new GameController(super.getModel(), monsterControllerFactory);
        drawGame.lanternaDraw(GUI);
        gameController.toDo(Key);
    }
}