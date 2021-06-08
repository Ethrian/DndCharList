package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Spell;
import com.Ethrian.dnd.DndCharList.service.SpellService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/spells")
public class SpellController {

    private SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping
    public ModelAndView getSpells(){
        List<Spell> spells = spellService.getAllSpells();
        ModelAndView model = new ModelAndView("spells");
        model.addObject("spells", spells);
        return model;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView editSpell(@PathVariable("id") Long id){
        Spell spell = spellService.getSpell(id);
        ModelAndView model = new ModelAndView("/editSpell");
        model.addObject("spell", spell);
        return model;
    }

    @DeleteMapping(value = "/{id}")
    public ModelAndView deleteSpell(@PathVariable("id") Long id){
        spellService.deleteSpell(id);
        return new ModelAndView("redirect:/spells");
    }

    @PostMapping
    public ModelAndView saveSpell(
            @RequestParam("spellId") Long id,
            @RequestParam String name,
            @RequestParam Integer lvl,
            @RequestParam String spellType,
            @RequestParam String castTime,
            @RequestParam String distance,
            @RequestParam String duration,
            @RequestParam(required = false) Boolean V,
            @RequestParam(required = false) Boolean S,
            @RequestParam(required = false) String M,
            @RequestParam String description
    ){
        spellService.updateName(id, name);
        spellService.updateDescription(id, description);
        spellService.updateParams(id, lvl, spellType, castTime, distance, duration, V, S, M);
        return new ModelAndView("redirect:/spells");
    }

    @PostMapping(value = "/new")
    public ModelAndView newSpell(
            @RequestParam String name,
            @RequestParam Integer lvl,
            @RequestParam String spellType,
            @RequestParam String castTime,
            @RequestParam String distance,
            @RequestParam String duration,
            @RequestParam(required = false) Boolean V,
            @RequestParam(required = false) Boolean S,
            @RequestParam(required = false) String M,
            @RequestParam String description
    ){
        spellService.createSpell(name, description, lvl, spellType, castTime, distance, duration, V, S, M);
        return new ModelAndView("redirect:/spells");
    }

}
