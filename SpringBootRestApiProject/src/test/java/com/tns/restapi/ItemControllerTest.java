package com.tns.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tns.restapi.entity.Item;
import com.tns.restapi.entity.controller.ItemController;
import com.tns.restapi.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @MockBean
    private ItemRepository itemRepository; // Mocked ItemRepository

    @Autowired
    private MockMvc mockMvc; // Autowired MockMvc instance

    @Autowired
    private ObjectMapper objectMapper; // Autowired ObjectMapper

    @Test
    public void testGetAllItems() throws Exception {
        Item item = new Item(1L, "Test Item", 50); // Create a test item
        List<Item> itemList = Collections.singletonList(item);

        // Mocking the repository's findAll method to return itemList
        when(itemRepository.findAll()).thenReturn(itemList);

        // Performing a GET request to "/items" endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/items"))
                // Verifying the HTTP status code is OK (200)
                .andExpect(MockMvcResultMatchers.status().isOk())
                // Additional assertions based on the controller response
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(itemList)));
    }

    @Test
    public void testGetItem() throws Exception {
        long itemId = 1L;
        Item item = new Item(itemId, "Test Item", 50); // Create a test item

        // Mocking the repository's findById method to return a specific item
        when(itemRepository.findById(itemId)).thenReturn(item);

        // Performing a GET request to "/item/{id}" endpoint with itemId
        mockMvc.perform(MockMvcRequestBuilders.get("/item/{id}", itemId))
                // Verifying the HTTP status code is OK (200)
                .andExpect(MockMvcResultMatchers.status().isOk())
                // Additional assertions based on the controller response
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(item)));
    }

    @Test
    public void testCreateItem() throws Exception {
        Item newItem = new Item(2L, "New Item", 75.0); // Create a new test item

        // Performing a POST request to "/item/add" endpoint with the new item content
        mockMvc.perform(MockMvcRequestBuilders.post("/item/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(newItem)))
                // Verifying the HTTP status code is Created (201)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testUpdateItem() throws Exception {
        long itemId = 1L;
        Item existingItem = new Item(itemId, "Test Item", 50); // Existing item with ID 1

        // Mocking the repository's findById method to return an existing item
        when(itemRepository.findById(itemId)).thenReturn(existingItem);

        // Performing a PUT request to "/item/update/{id}" endpoint with itemId
        mockMvc.perform(MockMvcRequestBuilders.put("/item/update/{id}", itemId)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(existingItem)))
                // Verifying the HTTP status code is OK (200)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteItem() throws Exception {
        long itemId = 1L;
        Item existingItem = new Item(itemId, "Test Item", 50); // Existing item with ID 1

        // Mocking the repository's findById method to return an existing item
        when(itemRepository.findById(itemId)).thenReturn(existingItem);

        // Performing a DELETE request to "/item/delete/{id}" endpoint with itemId
        mockMvc.perform(MockMvcRequestBuilders.delete("/item/delete/{id}", itemId))
                // Verifying the HTTP status code is OK (200)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    // Additional test methods can be added here as needed...

}
