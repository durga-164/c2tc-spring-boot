package com.tns.restapi;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tns.restapi.entity.Item;
import com.tns.restapi.entity.service.ItemService;
import com.tns.restapi.repository.ItemRepository;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository; // Mock ItemRepository

    @InjectMocks
    private ItemService itemService; // Inject the mocked ItemRepository into the ItemService

    private Item testItem;

    @BeforeEach
    public void setUp() {
        testItem = new Item();
        testItem.setId(1L);
        testItem.setName("Test Item");
        testItem.setPrice((float) 50.0);
        // Set up any other properties of testItem as needed
    }

    @Test
    public void testGetAllItems() {
        // Mock the behavior of itemRepository.findAll() to return a list of items
        List<Item> itemList = new ArrayList<>();
        itemList.add(testItem);
        when(itemRepository.findAll()).thenReturn(itemList);

        List<Item> result = itemService.getAllItems(); // Call the method being tested

        assertEquals(itemList, result); // Verify that the result matches the mocked list
    }

    @Test
    public void testGetItemById() {
        // Mock the behavior of itemRepository.findById() to return the testItem directly
        when(itemRepository.findById(1L)).thenReturn(testItem);

        Item result = itemService.getItemById(1L); // Call the method being tested

        assertEquals(testItem, result); // Verify that the result matches the mocked item
    }


    @Test
    public void testGetItemsByCategory() {
        // Mock the behavior of itemRepository.findByCategory() to return a list of items for a given category
        List<Item> itemList = new ArrayList<>();
        itemList.add(testItem);
        when(itemRepository.findByCategory("TestCategory")).thenReturn(itemList);

        List<Item> result = itemService.getItemsByCategory("TestCategory"); // Call the method being tested

        assertEquals(itemList, result); // Verify that the result matches the mocked list
    }

    @Test
    public void testCreateItem() {
        itemService.createItem(testItem); // Call the method being tested

        verify(itemRepository, times(1)).save(testItem); // Verify that itemRepository.save() was called once with the testItem
    }

    @Test
    public void testUpdateItemPrice() {
        // Mock the behavior of itemRepository.findById() to return an item for a given ID
        when(itemRepository.findById(1L)).thenReturn(testItem);

        Item updatedItem = itemService.updateItemPrice(1L, 75.0f); // Call the method being tested

        // Check if the item is not null before accessing its properties
        assertNotNull(updatedItem);
        assertEquals(75.0, updatedItem.getPrice()); // Verify that the price of the updated item matches the expected value
        verify(itemRepository, times(1)).save(testItem); // Verify that itemRepository.save() was called once
    }

    @Test
    public void testDeleteItem() {
        // Mock the behavior of itemRepository.findById() to return an item for a given ID
        when(itemRepository.findById(1L)).thenReturn(testItem);

        itemService.deleteItem(1L); // Call the method being tested

        verify(itemRepository, times(1)).delete(testItem); // Verify that itemRepository.delete() was called once with the testItem
    }

    @Test
    public void testUpdateItem() {
        // This test method is a placeholder for future implementation or can be further developed to test the updateItem method.
        // As the updateItem method in the service class is currently a stub, you may extend this test method to cover additional logic.
        // For now, the method is not implemented in the service class and will remain as a stub.
        itemService.updateItem(testItem); // Call the method being tested (stub)
        // You can extend this test when the updateItem method is implemented in the service class
        assertNull(75); // Placeholder assertion
    }
}
