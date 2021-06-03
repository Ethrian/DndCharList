package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Character;
import com.Ethrian.dnd.DndCharList.model.Item;
import com.Ethrian.dnd.DndCharList.model.Spell;
import com.Ethrian.dnd.DndCharList.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Controller
@RequestMapping(value = "/characters")
public class CharacterController {

    private final Logger logger = LoggerFactory.getLogger(CharacterController.class);

    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping(value = "/{character_id}")
    public String getCharacter(@PathVariable("character_id") Long id, Map<String, Object> model){
        logger.info("Get character with ID: {}", id);
        Character character = characterService.getCharacterById(id);
        model.put("character", character);
        return "character";
    }

    @PostMapping(value = "/new")
    public String createCharacter(
            @RequestParam String name,
            @RequestParam String gender,
            Map<String, Object> model
    ){
        Character character = characterService.newCharacter(name, gender);
        model.put("character", character);
        return "/character";
    }


    @GetMapping(value = "/getDescription/{character_id}")
    public String getCharactersDescription(
            @RequestParam("character_id") Character character,
            Map<String, Object> model
    ){

        return "character";
    }

    @PostMapping(value = "/updateAbilities/{character_id}")
    public String updateAbilities(
            @RequestParam("character_id") Character character,
            @RequestParam Integer STR, @RequestParam Integer DEX,
            @RequestParam Integer CON, @RequestParam Integer INT,
            @RequestParam Integer WIS, @RequestParam Integer CHA,
            Map<String, Object> model
    ){
        Character updatedCharacter = characterService.updateAbilities(character, STR, DEX, CON, INT, WIS, CHA);
        model.put("character", updatedCharacter);
        return "character";
    }

    @PostMapping(value = "/updateStats/{character_id}")
    public String updateStats(
            @RequestParam("character_id") Character character,
            @RequestParam Integer armorClass,
            @RequestParam Integer exp,
            @RequestParam Integer speed,
            Map<String, Object> model
    ){
        Character updatedCharacter = characterService.updateStats(character, armorClass, exp, speed);
        model.put("character", updatedCharacter);
        return "character";
    }

    @PostMapping(value = "/updateHp/{character_id}")
    public String updateHp(
            @RequestParam("character_id") Character character,
            @RequestParam Integer maxHp,
            @RequestParam Integer curHp,
            @RequestParam Integer tmpHp,
            @RequestParam Integer deathSavesFailed,
            @RequestParam Integer deathSavesPassed,
            @RequestParam Integer currentHitDices,
            Map<String, Object> model
    ){
        Character updatedCharacter = characterService.updateHp(character, maxHp, curHp, tmpHp, deathSavesFailed, deathSavesPassed, currentHitDices);
        model.put("character", updatedCharacter);
        return "character";
    }

    @PostMapping(value = "/updateSkills/{character_id}")
    public String updateSkills(
            @RequestParam("character_id") Character character,
            @RequestParam Integer athletic,
            @RequestParam Integer acrobatic,
            @RequestParam Integer sleightOfHands,
            @RequestParam Integer stealth,
            @RequestParam Integer investigation,
            @RequestParam Integer history,
            @RequestParam Integer nature,
            @RequestParam Integer arcana,
            @RequestParam Integer religion,
            @RequestParam Integer perception,
            @RequestParam Integer insight,
            @RequestParam Integer survival,
            @RequestParam Integer medicine,
            @RequestParam Integer animalHandling,
            @RequestParam Integer deception,
            @RequestParam Integer intimidation,
            @RequestParam Integer performance,
            @RequestParam Integer persuasion,
            Map<String, Object> model
    ) {
        Character updatedCharacter = characterService.updateSkills(
                character,
                athletic,
                acrobatic, sleightOfHands, stealth,
                investigation, history, nature, arcana, religion,
                perception, insight, survival, medicine, animalHandling,
                deception, intimidation, performance, persuasion
        );

        model.put("character", updatedCharacter);
        return "character";
    }

    @PostMapping(value = "/addSpell/{character_id}")
    public String addSpell(
            @RequestParam("character_id") Character character,
            @RequestParam("spell_id") Spell spell,
            Map<String, Object> model
    ){

        return "character";
    }

    @PostMapping(value = "/removeSpell/{character_id}")
    public String removeSpell(
            @RequestParam("character_id") Character character,
            @RequestParam("spell_id") Spell spell,
            Map<String, Object> model
    ){

        return "character";
    }

    @GetMapping(value = "/getSpells/{character_id}")
    public String getSpells(
            @RequestParam("character_id") Character character,
            Map<String, Object> model
    ){

        return "character";
    }

    @PostMapping(value = "/addItem/{character_id}")
    public String addItem(
            @RequestParam("character_id") Character character,
            @RequestParam("item_id") Item item,
            Map<String, Object> model
    ){

        return "character";
    }

    @PostMapping(value = "/removeItem/{character_id}")
    public String removeItem(
            @RequestParam("character_id") Character character,
            @RequestParam("item_id") Item item,
            Map<String, Object> model
    ){

        return "character";
    }

    @GetMapping(value = "/getItems/{character_id}")
    public String getItems(
            @RequestParam("character_id") Character character,
            Map<String, Object> model
    ){

        return "character";
    }

    @GetMapping(value = "/getRace/{character_id}")
    public String getRace(
            @RequestParam("character_id") Character character,
            Map<String, Object> model
    ){

        return "character";
    }

    @PostMapping(value = "/addRace/{character_id}")
    public String addRace(
            @RequestParam("character_id") Character character,
            Map<String, Object> model
    ){

        return "character";
    }

    @GetMapping(value = "/getCharacterClass/{character_id}")
    public String getCharacterClass(
            @RequestParam("character_id") Character character,
            Map<String, Object> model
    ){

        return "character";
    }

    @PostMapping(value = "/addCharacterClass/{character_id}")
    public String addCharacterClass(
            @RequestParam("character_id") Character character,
            Map<String, Object> model
    ){

        return "character";
    }

    @PostMapping(value = "/updateDescription/{character_id}")
    public String updateDescription(
            @RequestParam("character_id") Character character,
            @RequestParam String name,
            @RequestParam String appearance,
            @RequestParam String background,
            @RequestParam String gender,
            Map<String, Object> model
    ){

        return "character";
    }


}
