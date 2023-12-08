package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.OptionsController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.OptionsModel;
import com.Carlos.spaceinvaders.view.menu.DrawOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class OptionsStateTest {

    @Mock
    private OptionsModel optionsModel;

    @Mock
    private DrawOptions drawOptions;

    @Mock
    private OptionsController optionsController;

    private OptionsState optionsState;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        optionsState = new OptionsState(optionsModel);
        optionsState.setDrawOptions(drawOptions);
        optionsState.setOptionsController(optionsController);
    }

    @Test
    void step_ShouldCallLanternaDrawAndOptionsControllerToDo() throws IOException {
        String key = "A";
        LanternaGui gui = mock(LanternaGui.class);
        long time = 1000L;
        Game game = mock(Game.class);

        optionsState.step(key, gui, time, game);

        verify(drawOptions).lanternaDraw(gui);
        verify(optionsController).toDo(game, key, time);
    }
}