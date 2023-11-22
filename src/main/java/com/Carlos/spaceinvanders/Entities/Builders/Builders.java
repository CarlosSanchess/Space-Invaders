package com.Carlos.spaceinvanders.Entities.Builders;

import com.Carlos.spaceinvanders.Entities.WallModel;
import com.Carlos.spaceinvanders.Entities.PositionModel;


import java.util.ArrayList;
import java.util.List;

public class Builders {
    public static List<WallModel> createWalls (int width, int height){
        List<WallModel> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new WallModel(new PositionModel(  c, 0)));
            walls.add(new WallModel(new PositionModel(c, height - 1)));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new WallModel(new PositionModel(0, r)));
            walls.add(new WallModel(new PositionModel(width - 1, r)));
        }
        return walls;
    }
}
