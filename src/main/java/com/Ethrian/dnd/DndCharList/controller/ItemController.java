package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Item;
import com.Ethrian.dnd.DndCharList.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/items")
public class ItemController {

    private ItemService itemService;

    public ItemController(
            ItemService itemService
    ) {
        this.itemService = itemService;
    }

    @GetMapping
    public ModelAndView getItems(){
        List<Item> items = itemService.getAllItems();
        ModelAndView model = new ModelAndView("items");
        model.addObject("items", items);
        return model;
    }

    @GetMapping(value = "/edit/{itemId}")
    public ModelAndView editItem(@PathVariable Long id){
        Item item = itemService.getItem(id);
        ModelAndView model = new ModelAndView("editItem");
        model.addObject("item", item);
        return model;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ModelAndView deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return new ModelAndView("redirect:/items");
    }


    @PostMapping(value = "/{itemId}")
    public ModelAndView saveItem(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double weight,
            @RequestParam String itemType
    ){
        itemService.updateName(id, name);
        itemService.updateDescription(id, description);
        Item item = itemService.updateParams(id, itemType, weight, 1);
        return new ModelAndView("redirect:/items");
    }

    @PostMapping(value = "/new")
    public ModelAndView newItem(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double weight,
            @RequestParam String itemType
    ){
        Item item = itemService.createItem(name, description, weight, itemType, 1);
        return new ModelAndView("redirect:/items");
    }

}
