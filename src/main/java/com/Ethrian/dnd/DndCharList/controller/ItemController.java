package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Item;
import com.Ethrian.dnd.DndCharList.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@Controller
@RequestMapping(value = "/user/{userId}/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(name = "/")
    public String getItems(Map<String, Object> model){
        List<Item> items = itemService.getAllItems();
        model.put("items", items);
        return "items";
    }

    @GetMapping(name = "/edit/{itemId}")
    public String editItem(@PathVariable Long id, Map<String, Object> model){
        Item item = itemService.getItem(id);
        model.put("item", item);
        return "/editItem";
    }

    @GetMapping(name = "/delete")
    public String deleteItem(@PathVariable Long id, Map<String, Object> model){
        itemService.deleteItem(id);
        return "redirect:/items";
    }


    @PostMapping(name = "/{itemId}")
    public String saveItem(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double weight,
            @RequestParam String itemType,
            Map<String, Object> model
    ){
        itemService.updateName(id, name);
        itemService.updateDescription(id, description);
        Item item = itemService.updateParams(id, itemType, weight, 1);
        model.put("item", item);
        return "redirect:/items";
    }

    @PostMapping(name = "/new")
    public String newItem(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double weight,
            @RequestParam String itemType,
            Map<String, Object> model
    ){
        Item item = itemService.createItem(name, description, weight, itemType, 1);
        model.put("item", item);
        return "redirect:/items";
    }

}
