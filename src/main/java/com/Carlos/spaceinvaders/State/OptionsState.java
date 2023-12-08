package com.Carlos.spaceinvaders.State;

import com.Carlos.spaceinvaders.Game;
import com.Carlos.spaceinvaders.controller.menu.OptionsController;
import com.Carlos.spaceinvaders.gui.LanternaGui;
import com.Carlos.spaceinvaders.model.models.OptionsModel;
import com.Carlos.spaceinvaders.view.menu.DrawOptions;

import java.io.IOException;

public class OptionsState extends State<OptionsModel>{

    private DrawOptions drawOptions;
    private OptionsController optionsController;

    public OptionsState(OptionsModel optionsModel) {
        super(optionsModel);
        this.drawOptions = new DrawOptions(getModel());
        this.optionsController = new OptionsController(getModel());
    }

    @Override
    public void step(String Key, LanternaGui GUI, long Time,Game game) throws IOException {
        drawOptions.lanternaDraw(GUI);
        optionsController.toDo(game,Key, Time);
    }

    public void setDrawOptions(DrawOptions drawOptions) {
        this.drawOptions = drawOptions;
    }

    public void setOptionsController(OptionsController optionsController) {
        this.optionsController = optionsController;
    }
}
