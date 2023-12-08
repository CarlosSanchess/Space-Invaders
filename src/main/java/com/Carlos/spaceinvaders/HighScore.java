package com.Carlos.spaceinvaders;
import java.io.*;
import java.nio.file.*;
import java.util.List;

public class HighScore {
    public static String absolutePath = System.getProperty("user.dir") + "/src/main/resources/HighScore.csv";


    public static void updateHighScore(String playerName, int score) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(absolutePath));
        } catch (IOException e) {
            System.err.println("Error loading high scores: " + e.getMessage());
            return;
        }

        boolean playerFound = false;
        int lowestScoreIndex = -1;
        int lowestScore = Integer.MAX_VALUE;

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String storedPlayerName = parts[0];
                int storedScore = Integer.parseInt(parts[1]);

                if (storedPlayerName.equals(playerName)) {
                    playerFound = true;
                    if (score > storedScore) {
                        lines.set(i, playerName + "," + score);
                    }
                    break;
                }

                if (storedScore < lowestScore) {
                    lowestScore = storedScore;
                    lowestScoreIndex = i;
                }
            }
        }

        if (!playerFound) {
            if (lines.size() < 10) { // 10 é o numero maximo de scores
                lines.add(playerName + "," + score);
            } else if (score > lowestScore) {
                lines.set(lowestScoreIndex, playerName + "," + score);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(absolutePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving high scores: " + e.getMessage());
        }
    }
}
