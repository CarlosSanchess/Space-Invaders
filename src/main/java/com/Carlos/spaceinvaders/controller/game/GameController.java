package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.Game;

import com.Carlos.spaceinvaders.HighScore;
import com.Carlos.spaceinvaders.State.GameOverMenuState;
import com.Carlos.spaceinvaders.State.ResumeMenuState;
import com.Carlos.spaceinvaders.controller.Controller;
import com.Carlos.spaceinvaders.controller.SoundController;
import com.Carlos.spaceinvaders.model.models.*;


public class GameController extends Controller<ArenaModel> {
    PlayerController playerController;
    BulletsController bulletsController;
    private final MonsterControllerFactory monsterControllerFactory;
    private final PowerUpFactory  powerUpFactory;
    private PowerUpController powerUpController;
    private MonsterFactory monsterFactory;
    private WallFactory wallFactory;


    private SoundController soundController;

    public GameController(ArenaModel arenaModel) {
        super(arenaModel);
        this.soundController = new SoundController();
        this.wallFactory = new WallFactory(getModel().getWidth(), getModel().getHeight(), getModel().getWalls());
        this.playerController = new PlayerController(getModel().getPlayer(), getModel().getWidth(), arenaModel.getActiveBullets(),soundController); //Passar a arena?
        this.bulletsController = new BulletsController(getModel().getActiveBullets(), getModel().getActiveMonsters(),getModel().getActivePowerUps(), getModel().getPlayer(), getModel().getScore(),getModel().getHeight());
        this.monsterControllerFactory = new MonsterControllerFactory(getModel().getWidth(),getModel().getHeight(), getModel().getActiveBullets(), getModel().getActiveMonsters(), getModel().getMonsterFactoryModel());
        this.powerUpFactory = new PowerUpFactory(getModel().getActivePowerUps());
        this.powerUpController = new PowerUpController(getModel().getActivePowerUps());
        this.monsterFactory = new MonsterFactory(getModel().getMonsterFactoryModel(),getModel().getActiveMonsters());
    }
    public void toDo(Game game,String keyPressed, long Time){

        if (keyPressed != null && (keyPressed.equals("Escape") || keyPressed.equals("Quit")) ) {
            game.pushState(new ResumeMenuState(new ResumeMenuModel()));

            int finalScore = getModel().getScore().getScore();
            PlayerModel playerModel = getModel().getPlayer();
            String playerName = playerModel.getPlayerNameModel();
            if (playerName == null) {
                playerName = playerModel.getPlayerNameModel();
            }
            System.out.println(playerName + " " + finalScore);

            HighScore.updateHighScore(playerName, finalScore);
        }
        powerUpFactory.createPowerUp(Time, getModel().getWidth()); // Fazer os monstros serem criados aqui?
        monsterControllerFactory.CreateMonstersAndControllers(Time);
        playerController.toDo(game,keyPressed,Time);
        bulletsController.toDo(game,keyPressed,Time); // Nao espera por nenhum keyboard input
        powerUpController.toDo(game,keyPressed, Time);
        for (MonsterController monsterController : monsterControllerFactory.getMonstersControllers()) {
            monsterController.toDo(game,null,Time);
        }

        endGame(game);
    }

    void endGame(Game game){

        if(getModel().getPlayer().getHitPoints() <= 0 || monsterControllerFactory.checkWinMonster()) {
            soundController.playSound("GameOver");
            game.popState();
            game.pushState(new GameOverMenuState(new GameOverMenuModel()));

            int finalScore = getModel().getScore().getScore();
            PlayerModel playerModel = getModel().getPlayer();
            String playerName = playerModel.getPlayerNameModel();
            if (playerName == null) {
                playerName = playerModel.getPlayerNameModel();
            }
            System.out.println(playerName + " " + finalScore);

            HighScore.updateHighScore(playerName, finalScore);
        }
    }

    public SoundController getSoundController() {
        return soundController;
    }

    public PowerUpController getPowerUpController() {
        return powerUpController;
    }

    public MonsterControllerFactory getMonsterControllerFactory() {
        return monsterControllerFactory;
    }

    public BulletsController getBulletsController() {
        return bulletsController;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public PowerUpFactory getPowerUpFactory() {
        return powerUpFactory;
    }

    public void setSoundController(SoundController soundController) {
        this.soundController = soundController;
    }
}