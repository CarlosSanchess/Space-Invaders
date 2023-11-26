package com.Carlos.spaceinvaders.model.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



public class ArenaTest {

    private ArenaModel arena;

    @BeforeEach
    public void setUp() throws InterruptedException {
        arena = new ArenaModel(100, 80);
    }

    @Test
    public void testGetWidth() {
        assertEquals(100, arena.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(80, arena.getHeight());
    }

    @Test
    public void testGetPlayer() {
        assertNotNull(arena.getPlayer());
    }

    @Test
    public void testGetActiveBullets() {
        assertNotNull(arena.getActiveBullets());
    }

    @Test
    public void testGetActiveMonsters() {
        assertNotNull(arena.getActiveMonsters());
    }

    @Test
    public void testGetWalls() {
        assertNotNull(arena.getWalls());
    }

    @Test
    public void testGetScore() {
        assertNotNull(arena.getScore());
    }
}
