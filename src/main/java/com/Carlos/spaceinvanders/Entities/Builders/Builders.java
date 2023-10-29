package com.Carlos.spaceinvanders.Entities.Builders;

import com.Carlos.spaceinvanders.Entities.wallModel;
import com.Carlos.spaceinvanders.Entities.positionModel;


import java.util.ArrayList;
import java.util.List;

public class Builders {
    public List<wallModel> createWalls (int width, int height){
        List<wallModel> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new wallModel(new positionModel(  c, 0)));
            walls.add(new wallModel(new positionModel(c, height - 1)));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new wallModel(new positionModel(0, r)));
            walls.add(new wallModel(new positionModel(width - 1, r)));
        }
        return walls;
    }
}
