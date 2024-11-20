package org.example;

import org.example.categories.Category;
import org.example.categories.RolCategory;
import org.example.models.BoardGame;
import org.example.models.DifficultyLevel;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryManagerTest {

    InventoryManager inventoryManager;

    @BeforeEach
    void init() {

        inventoryManager = new InventoryManager();
    }

    @Test
    void createNewGame() {
        inventoryManager.createNewGame(new BoardGame("uno", 13.5, DifficultyLevel.LOW, new RolCategory(), 10));
        assertEquals(1, inventoryManager.getAvailableGames().length);
        assertEquals("uno", inventoryManager.getAvailableGames()[0].getName());
    }
}