package com.tns.restapi;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tns.restapi.entity.Item;

public class ItemTest {

    private Item testItem;

    @BeforeEach
    public void setUp() {
        // Creating a test Item object
        testItem = new Item("Test Item", LocalDate.of(2023, 11, 20),
                LocalDate.of(2024, 11, 20), 50.0f, "TestCategory");
        testItem.setId(1L);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(1L, testItem.getId());
        assertEquals("Test Item", testItem.getName());
        assertEquals(LocalDate.of(2023, 11, 20), testItem.getManufacturing());
        assertEquals(LocalDate.of(2024, 11, 20), testItem.getExpiry());
        assertEquals(50.0f, testItem.getPrice());
        assertEquals("TestCategory", testItem.getCategory());

        // Modifying fields using setters
        testItem.setName("Updated Item");
        testItem.setPrice(75.0f);

        assertEquals("Updated Item", testItem.getName());
        assertEquals(75.0f, testItem.getPrice());
    }

    @Test
    public void testToString() {
        String expectedString = "Item [id=1, name=Test Item, manufacturing=2023-11-20, expiry=2024-11-20, price=50.0, category=TestCategory]";
        assertEquals(expectedString, testItem.toString());
    }
}
