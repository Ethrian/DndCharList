package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Spell;
import com.Ethrian.dnd.DndCharList.service.CharacterService;
import com.Ethrian.dnd.DndCharList.service.SpellService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/spells")
public class SpellController {

    private SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping(value = "/")
    public String getSpells(Map<String, Object> model){
        List<Spell> spells = spellService.getAllSpells();
        model.put("spells", spells);
        return "spells";
    }

    @GetMapping(value = "/{spellId}")
    public String editSpell(@PathVariable("spellId") Long id, Map<String, Object> model){
        Spell spell = spellService.getSpell(id);
        model.put("spell", spell);
        return "/editSpell";
    }

    @PostMapping(value = "/delete")
    public String deleteSpell(
            HttpSession session,
            @RequestParam("spellId") Long id,
            Map<String, Object> model
    ){
        List<Spell> spellList = spellService.getAllSpells();
        session.setAttribute("spells", spellList);
        spellService.deleteSpell(id);
        return "redirect:/spells";
    }

    @PostMapping
    public String saveSpell(
            @RequestParam("spellId") Long id,
            @RequestParam String name,
            @RequestParam Integer lvl,
            @RequestParam String spellType,
            @RequestParam String castTime,
            @RequestParam String distance,
            @RequestParam String duration,
            @RequestParam Boolean V,
            @RequestParam Boolean S,
            @RequestParam String M,
            @RequestParam String description,
            Map<String, Object> model
    ){
        spellService.updateName(id, name);
        spellService.updateDescription(id, description);
        Spell spell = spellService.updateParams(id, lvl, spellType, castTime, distance, duration, V, S, M);
        model.put("spell", spell);
        return "redirect:/spells";
    }

    @PostMapping(value = "/new")
    public String newSpell(
            @RequestParam String name,
            @RequestParam Integer lvl,
            @RequestParam String spellType,
            @RequestParam String castTime,
            @RequestParam String distance,
            @RequestParam String duration,
            @RequestParam Boolean V,
            @RequestParam Boolean S,
            @RequestParam String M,
            @RequestParam String description,
            Map<String, Object> model
    ){
        Spell spell = spellService.createSpell(name, description, lvl, spellType, castTime, distance, duration, V, S, M);
        model.put("spell", spell);
        return "/spells";
    }

}
