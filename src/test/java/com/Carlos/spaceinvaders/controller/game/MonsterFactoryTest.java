package com.Carlos.spaceinvaders.controller.game;

import com.Carlos.spaceinvaders.model.models.MonsterFactoryModel;
import com.Carlos.spaceinvaders.model.models.MonsterModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MonsterFactoryTest {

    private MonsterFactory monsterFactory;
    private List<MonsterModel> activeMonsters;

    @BeforeEach
    public void setUp() {
        MonsterFactoryModel monsterFactoryModel = new MonsterFactoryModel();
        activeMonsters = new ArrayList<>();
        monsterFactory = new MonsterFactory(monsterFactoryModel, activeMonsters);
    }

    @Test
    public void testCreateMonster_WhenTimeIsGreaterThanDelay_ShouldReturnNewMonsters() {
        long time = 1000;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertEquals(1, activeMonsters.size());
    }

    @Test
    public void testCreateMonster_WhenTimeIsLessThanDelay_ShouldReturnNull() {
        long time = 500;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertNull(activeMonsters);
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToDelay_ShouldReturnNull() {
        long time = 100;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertNull(activeMonsters);
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToDelayPlusOne_ShouldReturnNewMonsters() {
        long time = 101;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertEquals(1, activeMonsters.size());
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToLastCreation_ShouldReturnNull() {
        long time = 0;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertNull(activeMonsters);
    }

    @Test
    public void testCreateMonster_WhenTimeIsGreaterThanLastCreation_ShouldReturnNewMonsters() {
        long time = 1000;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertEquals(1, activeMonsters.size());
    }

    @Test
    public void testCreateMonster_WhenTimeIsLessThanLastCreation_ShouldReturnNull() {
        long time = 500;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertNull(activeMonsters);
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToLastCreationPlusOne_ShouldReturnNewMonsters() {
        long time = 1;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertEquals(1, activeMonsters.size());
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToLastCreationMinusOne_ShouldReturnNull() {
        long time = -1;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertNull(activeMonsters);
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToLastCreationMinusDelay_ShouldReturnNewMonsters() {
        long time = -1000;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertEquals(1, activeMonsters.size());
    }

    @Test
    public void testCreateMonster_WhenTimeIsLessThanLastCreationMinusDelay_ShouldReturnNull() {
        long time = -1500;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertNull(activeMonsters);
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToLastCreationMinusDelayPlusOne_ShouldReturnNewMonsters() {
        long time = -999;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertEquals(1, activeMonsters.size());
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToLastCreationMinusDelayMinusOne_ShouldReturnNull() {
        long time = -1001;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertNull(activeMonsters);
    }

    @Test
    public void testCreateMonster_WhenTimeIsEqualToLastCreationMinusDelayMinusTwo_ShouldReturnNull() {
        long time = -1002;
        int arenaX = 10;
        monsterFactory.createMonster(time, arenaX);

        assertNull(activeMonsters);
    }
}