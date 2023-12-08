package com.Carlos.spaceinvaders.view.menu;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.HighScoresModel;
import com.Carlos.spaceinvaders.model.models.PositionModel;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DrawHighScoresTest {

    @Mock
    private LanternaGui gui;

    @Mock
    private HighScoresModel highScoresModel;

    private DrawHighScores drawHighScores;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        drawHighScores = new DrawHighScores(highScoresModel);
    }

    @Test
    public void testDrawTitle() {
        drawHighScores.drawTitle(gui);
        verify(gui, times(1)).drawText(any(PositionModel.class), eq("HIGH SCORES"), any(TextColor.RGB.class), eq(false));
        verify(gui, times(1)).drawText(any(PositionModel.class), eq("NAME"), any(TextColor.RGB.class), eq(false));
        verify(gui, times(1)).drawText(any(PositionModel.class), eq("SCORE"), any(TextColor.RGB.class), eq(false));
    }

    @Test
    public void testDrawScores() throws IOException {
        when(highScoresModel.getFilePath()).thenReturn("testPath");
        when(highScoresModel.getEntryName()).thenReturn("Exit");
        Path path = Paths.get("testPath");
        Files.write(path, Arrays.asList("John,100", "Jane,200"));

        drawHighScores.drawScores(gui);

        verify(gui, times(1)).drawText(any(PositionModel.class), eq("John"), any(TextColor.RGB.class), eq(false));
        verify(gui, times(1)).drawText(any(PositionModel.class), eq("100"), any(TextColor.RGB.class), eq(false));
        verify(gui, times(1)).drawText(any(PositionModel.class), eq("Jane"), any(TextColor.RGB.class), eq(false));
        verify(gui, times(1)).drawText(any(PositionModel.class), eq("200"), any(TextColor.RGB.class), eq(false));
        verify(gui, times(1)).drawText(any(PositionModel.class), eq("Exit"), any(TextColor.RGB.class), eq(false));
    }
}