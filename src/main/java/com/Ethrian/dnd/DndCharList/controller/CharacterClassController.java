package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.CharacterClass;
import com.Ethrian.dnd.DndCharList.model.Dice;
import com.Ethrian.dnd.DndCharList.model.Item;
import com.Ethrian.dnd.DndCharList.model.Race;
import com.Ethrian.dnd.DndCharList.service.CharacterClassService;
import com.Ethrian.dnd.DndCharList.service.RaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/class")
public class CharacterClassController {

    private CharacterClassService characterClassService;

    public CharacterClassController(CharacterClassService characterClassService) {
        this.characterClassService = characterClassService;
    }

    @GetMapping
    public ModelAndView getClasses(){
        List<CharacterClass> characterClasses = characterClassService.getAllClasses();
        ModelAndView model = new ModelAndView("charClasses");
        model.addObject("characterClasses", characterClasses);
        model.addObject("hitDices", Dice.values());
        return model;
    }

    @GetMapping(value = "/{classId}")
    public ModelAndView editClass(@PathVariable("classId") Long id){
        CharacterClass characterClass = characterClassService.getCharacterClass(id);
        ModelAndView model = new ModelAndView("editClass");
        model.addObject("characterClass", characterClass);
        model.addObject("hitDices", Dice.values());
        return model;
    }


    @PostMapping(value = "/delete/{id}")
    public ModelAndView deleteClass(@PathVariable Long id){
        characterClassService.deleteCharacterClass(id);
        return new ModelAndView("redirect:/class");
    }

    @PostMapping
    public ModelAndView saveClass(
            @RequestParam("classId") Long id,
            @RequestParam String name,
            @RequestParam Dice hitDice,
            @RequestParam(required = false) Integer lvl
    ){
        characterClassService.updateName(id, name);
        CharacterClass characterClass = characterClassService.updateDice(id, hitDice);
        if(characterClass.getDirty()) characterClassService.updateLvl(id, lvl);
        return new ModelAndView("redirect:/class");
    }

    @PostMapping(value = "/new")
    public ModelAndView newClass(
            @RequestParam String name,
            @RequestParam Dice hitDice
    ){
        characterClassService.createCharacterClass(name, hitDice);
        return new ModelAndView("redirect:/class");
    }
}
