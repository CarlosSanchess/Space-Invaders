package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsTest {
    @Test
    public void testGetEntryName() {
        OptionsModel optionsModel = new OptionsModel();
        String expectedEntryName = "Exit";
        String actualEntryName = optionsModel.getEntryName();
        Assertions.assertEquals(expectedEntryName, actualEntryName);
    }
}