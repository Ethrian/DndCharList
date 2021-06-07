package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.CharacterClass;
import com.Ethrian.dnd.DndCharList.model.Dice;
import com.Ethrian.dnd.DndCharList.model.Item;
import com.Ethrian.dnd.DndCharList.service.CharacterClassService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user/{userId}/class")
public class CharacterClassController {

    private CharacterClassService characterClassService;

    public CharacterClassController(CharacterClassService characterClassService) {
        this.characterClassService = characterClassService;
    }

    @GetMapping(name = "/")
    public String getClasses(Map<String, Object> model){
        List<CharacterClass> characterClasses = characterClassService.getAllClasses();
        model.put("characterClasses", characterClasses);
        return "/charClasses";
    }

    @GetMapping(name = "/{classId}")
    public String editClass(@PathVariable Long id, Map<String, Object> model){
        CharacterClass characterClass = characterClassService.getCharacterClass(id);
        model.put("characterClass", characterClass);
        return "/editClass";
    }

    @GetMapping(name = "/delete")
    public String deleteClass(@PathVariable Long id, Map<String, Object> model){
        characterClassService.deleteCharacterClass(id);
        return "redirect:/charClasses";
    }


    @PostMapping(name = "/{classId}")
    public String saveClass(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam Dice hitDice,
            Map<String, Object> model
    ){
        characterClassService.updateName(id, name);
        CharacterClass characterClass = characterClassService.updateDice(id, hitDice);
        model.put("characterClass", characterClass);
        return "redirect:/charClasses";
    }

    @PostMapping(name = "/new")
    public String newClass(
            @RequestParam String name,
            @RequestParam Dice hitDice,
            Map<String, Object> model
    ){
        CharacterClass characterClass = characterClassService.createCharacterClass(name, hitDice);
        model.put("characterClass", characterClass);
        return "redirect:/charClasses";
    }
}
