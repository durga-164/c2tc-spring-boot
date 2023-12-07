package com.tns.restapi.entity.controller;

import com.tns.restapi.entity.Item;
import com.tns.restapi.entity.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @CrossOrigin(origins = "http://localhost:3000") // Adding @CrossOrigin at class level to cover all mappings
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        try {
            return itemService.getAllItems();
        } catch (Exception e) {
            // Log the exception or handle it as required
            e.printStackTrace();
            return null; // Or return an empty list or throw a custom exception
        }
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable long id) {
        try {
            return itemService.getItemById(id);
        } catch (Exception e) {
            // Log the exception or handle it as required
            e.printStackTrace();
            return null; // Or return null or throw a custom exception
        }
    }

    @GetMapping("/items/{category}")
    public List<Item> getItemsByCategory(@PathVariable String category) {
        try {
            return itemService.getItemsByCategory(category);
        } catch (Exception e) {
            // Log the exception or handle it as required
            e.printStackTrace();
            return null; // Or return an empty list or throw a custom exception
        }
    }

    @PostMapping("/item/add")
    public void createItem(@RequestBody Item item) {
        try {
            itemService.createItem(item);
        } catch (Exception e) {
            // Log the exception or handle it as required
            e.printStackTrace();
            // Maybe throw a custom exception or return a specific response
        }
    }

    @PutMapping("/item/update/{id}")
    public Item updateItem(@PathVariable long id, @RequestBody Item updatedItem) {
        try {
            Item item = itemService.getItemById(id);
            if (item != null) {
                item.setPrice(updatedItem.getPrice());
                // Update other fields similarly if needed
                itemService.updateItem(item);
                return item;
            } else {
                return null; // Handle the case where the item with the given ID is not found
            }
        } catch (Exception e) {
            // Log the exception or handle it as required
            e.printStackTrace();
            return null; // Or throw a custom exception or return a specific response
        }
    }

    @DeleteMapping("/item/delete/{id}")
    public void deleteItem(@PathVariable long id) {
        try {
            itemService.deleteItem(id);
        } catch (Exception e) {
            // Log the exception or handle it as required
            e.printStackTrace();
            // Maybe throw a custom exception or return a specific response
        }
    }
}
