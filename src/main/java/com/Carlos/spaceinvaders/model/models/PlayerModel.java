package com.Carlos.spaceinvaders.model.models;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.Carlos.spaceinvaders.HighScore;
import  com.Carlos.spaceinvaders.model.models.PowerUp.PowerUpType;



public class PlayerModel extends Elements {

    private int hitPoints; //Not Used Yet
    private long delayShooting;
    private PowerUpType powerUpType;
    public PlayerNameModel playerNameModel;
    public static int i;

    public PlayerModel(PositionModel position, int hitPoints, PowerUpType powerUpType){
        super(position);
        this.hitPoints = hitPoints;
        this.delayShooting = 500;
        this.powerUpType = null;
        this.playerNameModel = playerNameModel;
        this.i = 1;

    }
    public BulletModel playerShoot(){
        return new BulletModel(new PositionModel(getPosition().getX(), getPosition().getY()),1,true); // Criar novo objeto para nao alterar o movimento da nave
    }

    public boolean canMove(PositionModel position) { // Permitir escolher tamanho da arena?
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return position.getX() >= 1 && position.getX()  < screenSize.width - 1;
    }

    public int getHitPoints() {
        return hitPoints;
    }
    public void incrementHitPoints(){
        this.hitPoints++;
    }
    public void decrementHitPoints(){
        this.hitPoints--;
    }
    public void setDelayShooting(long delayShooting) {
        this.delayShooting = delayShooting;
    }
    public long getDelayShooting() {
        return delayShooting;
    }
    public PowerUpType getPowerUpType() {
        return powerUpType;
    }
    public void setPowerUpType(PowerUpType powerUpType) {
        this.powerUpType = powerUpType;
    }

    public String getPlayerNameModel() {
        System.out.println("aaaa");
        System.out.println(playerNameModel);

        if (playerNameModel == null) {
            int highestGuestNumber = findHighestGuestNumber();
            return "Guest" + (highestGuestNumber + 1);
        }

        return playerNameModel.getName();
    }

    private int findHighestGuestNumber() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(HighScore.absolutePath));

            int highestGuestNumber = 1;

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String storedPlayerName = parts[0];

                    if (storedPlayerName.startsWith("Guest")) {
                        try {
                            int guestNumber = Integer.parseInt(storedPlayerName.substring(5));
                            highestGuestNumber = Math.max(highestGuestNumber, guestNumber);
                        } catch (NumberFormatException ignored) {
                            // Ignore if the number couldn't be parsed
                        }
                    }
                }
            }

            return highestGuestNumber;
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return 0;
        }
    }


    public void setPlayerNameModel(PlayerNameModel playerNameModel) {
        this.playerNameModel = playerNameModel;
    }
}