package com.Carlos.spaceinvaders;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Objects;

public class HighScore {
    private int score;
    private static String filePath = "/HighScore.csv";
    private static String absolutePath = System.getProperty("user.dir") + "/src/main/resources/HighScore.csv";

    public HighScore(int score) {
        this.score = score;
    }

    public static int loadHighScore() {
        int highScore = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(HighScore.class.getResourceAsStream(filePath))))) {
            String line;
            if ((line = reader.readLine()) != null) {
                highScore = Integer.parseInt(line);
            }
        } catch (IOException e) {
            System.err.println("Error loading high score: " + e.getMessage());
        }
        return highScore;
    }
    public static void saveHighScore(int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(absolutePath, false))) {
            writer.println(score);
        } catch (IOException e) {
            System.err.println("Error saving high score: " + e.getMessage());
        }
    }
}