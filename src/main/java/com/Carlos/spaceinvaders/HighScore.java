package com.Carlos.spaceinvaders;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.*;

public class HighScore {
    private int score;
    private static String filePath = "HighScore.csv";

    public HighScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public static int loadHighScore() {
        int highScore = 0;
        try (InputStream in = HighScore.class.getResourceAsStream("/" + filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
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
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            writer.println(score);
        } catch (IOException e) {
            System.err.println("Error saving high score: " + e.getMessage());
        }
    }
}