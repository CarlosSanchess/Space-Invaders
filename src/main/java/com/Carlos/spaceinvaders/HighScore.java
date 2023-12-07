package com.Carlos.spaceinvaders;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;

public class HighScore {
    public static String absolutePath = System.getProperty("user.dir") + "/src/main/resources/HighScore.csv";


    public static void updateHighScore(String playerName, int score) {
        // Load existing scores from the CSV file
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(absolutePath));
        } catch (IOException e) {
            System.err.println("Error loading high scores: " + e.getMessage());
            return;
        }

        // Search for the player in the loaded scores
        boolean playerFound = false;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String storedPlayerName = parts[0];
                int storedScore = Integer.parseInt(parts[1]);

                // Update the score if the player is found
                if (storedPlayerName.equals(playerName)) {
                    playerFound = true;
                    if (score > storedScore) {
                        lines.set(i, playerName + "," + score);
                    }
                    break;
                }
            }
        }

        // If player not found, add a new entry
        if (!playerFound && !playerName.isEmpty()) {
            lines.add(playerName + "," + score);
        }

        // Save the updated scores back to the CSV file
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
