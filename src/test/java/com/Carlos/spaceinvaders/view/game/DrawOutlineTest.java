package com.Carlos.spaceinvaders.view.game;

import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.WallModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class DrawOutlineTest {

    @Mock
    private LanternaGui mockGui;

    private DrawOutline drawOutline;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        List<WallModel> walls = new ArrayList<>();
        drawOutline = new DrawOutline(walls);
    }

    @Test
    void draw_ShouldDrawEachWallModel() {
        WallModel wallModel1 = mock(WallModel.class);
        WallModel wallModel2 = mock(WallModel.class);
        List<WallModel> walls = new ArrayList<>();
        walls.add(wallModel1);
        walls.add(wallModel2);

        DrawOutline drawOutline = new DrawOutline(walls);

        drawOutline.draw(mockGui);

        verify(mockGui, times(walls.size())).drawText(any(), any(), any());
    }
}
