package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.HighScoresModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.Carlos.spaceinvaders.view.Viewer;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class DrawHighScores extends Viewer<HighScoresModel> {

    public DrawHighScores(HighScoresModel highScores) {
        super(highScores);
    }

    @Override
    protected void draw(LanternaGui gui) {
        drawTitle(gui);
        drawScores(gui);
    }

    void drawTitle(LanternaGui gui) {
        gui.drawText(new PositionModel(33, 7), "HIGH SCORES", new TextColor.RGB(178, 73, 210), false);
        gui.drawText(new PositionModel(32, 11), "NAME", new TextColor.RGB(178, 73, 210), false);
        gui.drawText(new PositionModel(42, 11), "SCORE", new TextColor.RGB(178, 73, 210), false);
    }

    void drawScores(LanternaGui gui) {
        String filePath = getModel().getFilePath();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            lines.sort(Comparator.comparingInt(line -> Integer.parseInt(((String) line).split(",")[1])).reversed());

            // Draw sorted scores
            int row = 14;
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(",");
                String name = parts[0];
                String score = parts[1];
                gui.drawText(new PositionModel(32, row), name, new TextColor.RGB(255, 255, 255), false);
                gui.drawText(new PositionModel(42, row), score, new TextColor.RGB(255, 255, 255), false);
                row += 2;
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        gui.drawText(new PositionModel(35, 35), getModel().getEntryName(), new TextColor.RGB(255, 0, 0), false);

    }
}
