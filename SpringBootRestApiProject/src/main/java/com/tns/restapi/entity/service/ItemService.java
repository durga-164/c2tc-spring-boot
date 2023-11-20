package com.tns.restapi.entity.service;

import com.tns.restapi.entity.Item;
import com.tns.restapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository; // Declare a private final field to hold the ItemRepository

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository; // Constructor-based injection of ItemRepository
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll(); // Retrieve all items from the repository
    }

    public Item getItemById(long id) {
        return itemRepository.findById(id); // Retrieve an item by its ID from the repository
    }

    public List<Item> getItemsByCategory(String category) {
        return itemRepository.findByCategory(category); // Retrieve items by category from the repository
    }

    public void createItem(Item item) {
        itemRepository.save(item); // Save a new item to the repository
    }

    public Item updateItemPrice(long id, float newPrice) {
        Item item = itemRepository.findById(id); // Retrieve the item by ID
        if (item != null) {
            item.setPrice(newPrice); // Update the item's price
            return itemRepository.save(item); // Save the updated item to the repository
        }
        return null; // Return null if the item is not found
    }

    public void deleteItem(long id) {
        Item item = itemRepository.findById(id); // Retrieve the item by ID
        if (item != null) {
            itemRepository.delete(item); // Delete the item from the repository
        }
    }

    // Placeholder method for updating an entire item
    public void updateItem(Item item) {
        // This method is not yet implemented
        // It could be used to update an entire item with new values, but it's currently a stub
    }
}
