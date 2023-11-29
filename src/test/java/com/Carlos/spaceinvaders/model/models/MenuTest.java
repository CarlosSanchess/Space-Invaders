package com.Carlos.spaceinvaders.model.models;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;




public class MenuTest {

    private MenuModel menuModel;

    @BeforeEach
    public void setUp() {
        menuModel = new MenuModel();
    }

    @Test
    public void testGetEntries() {
        List<String> entries = menuModel.getEntries();
        assertNotNull(entries);
        assertEquals(4, entries.size());
        assertEquals("NEW GAME", entries.get(0));
        assertEquals("TUTORIAL", entries.get(1));
        assertEquals("OPTIONS", entries.get(2));
        assertEquals("EXIT", entries.get(3));
    }

    @Test
    public void testGetColor() {
        TextColor.RGB color = menuModel.getColor("NEW GAME");
        assertNotNull(color);
        assertEquals(255, color.getRed());
        assertEquals(0, color.getGreen());
        assertEquals(0, color.getBlue());
    }

    @Test
    public void testNextEntry() {
        int initialEntry = menuModel.getEntry();
        //TODO
       // menuModel.nextEntry();
        assertEquals((initialEntry + 1) % 4, menuModel.getEntry());
    }

    @Test
    public void testPreviousEntry() {
        int initialEntry = menuModel.getEntry();
        //TODO
        //menuModel.previousEntry();
        assertEquals((initialEntry - 1 + 4) % 4, menuModel.getEntry());
    }

    @Test
    public void testGetText() {
        String expectedText =
            "                          _                     _               \n" +
            "                         (_)                   | |              \n" +
            " ___ _ __   __ _  ___ ___ _ _ ____   ____ _  __| | ___ _ __ ___ \n" +
            "/ __| '_ \\ / _` |/ __/ _ \\ | '_ \\ \\ / / _` |/ _` |/ _ \\ '__/ __|\n" +
            "\\__ \\.|_) | (_| | (_|  __/ | | | \\ V / (_| | (_| |  __/ |  \\__ \\\n" +
            "|___/ .__/ \\__,_|\\___\\___|_|_| |_|\\_/ \\__,_|\\__,_|\\___|_|  |___/\n" +
            "    | |                                                          \n" +
            "    |_|                                                          \n";
        String actualText = menuModel.getText();
        assertEquals(expectedText, actualText);
    }
}
