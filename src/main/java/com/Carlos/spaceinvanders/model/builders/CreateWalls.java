package com.Carlos.spaceinvanders.model.builders;

import com.Carlos.spaceinvanders.model.models.WallModel;
import com.Carlos.spaceinvanders.model.models.PositionModel;


import java.util.ArrayList;
import java.util.List;

public class CreateWalls {
    public static List<WallModel> createWalls (int width, int height){

        List<WallModel> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new WallModel(new PositionModel(c, 0))); // Top row
            walls.add(new WallModel(new PositionModel(c, height - 1))); // Bottom row
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new WallModel(new PositionModel(0, r))); // Left column
            walls.add(new WallModel(new PositionModel(width - 1, r))); // Right column
        }

        return walls;
    }
}
