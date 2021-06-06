package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Character;
import com.Ethrian.dnd.DndCharList.model.*;
import com.Ethrian.dnd.DndCharList.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/user/{userId}/characters")
public class CharacterController {

    private final Logger logger = LoggerFactory.getLogger(CharacterController.class);

    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping(value = "/")
    public String getUserCharacters(@PathVariable Long userId, Map<String, Object> model) {
        return "characters";
    }

    @GetMapping(value = "/{character_id}")
    public String getCharacter(@PathVariable("character_id") Long id, Map<String, Object> model){
        Character character = characterService.getCharacterById(id);
        model.put("character", character);
        return "character";
    }

    @PostMapping(value = "/new")
    public String createCharacter(
            @PathVariable String name,
            @PathVariable String gender,
            Map<String, Object> model
    ){
        Character character = characterService.createCharacter(name, gender);
        model.put("character", character);
        return "character";
    }


//    @GetMapping(value = "/getDescription/{character_id}")
//    public String getCharactersDescription(
//            @RequestParam("character_id") Character character,
//            Map<String, Object> model
//    ){
//
//        return "character";
//    }

    @PostMapping(value = "/updateAbilities/{character_id}")
    public String updateAbilities(
            @PathVariable("character_id") Long id,
            @RequestParam Integer STR, @RequestParam Integer DEX,
            @RequestParam Integer CON, @RequestParam Integer INT,
            @RequestParam Integer WIS, @RequestParam Integer CHA,
            Map<String, Object> model
    ){
        Character updatedCharacter = characterService.updateAbilities(id, STR, DEX, CON, INT, WIS, CHA);
        model.put("character", updatedCharacter);
        return "character";
    }

    @PostMapping(value = "/updateStats/{character_id}")
    public String updateStats(
            @PathVariable("character_id") Long id,
            @RequestParam Integer armorClass,
            @RequestParam Integer exp,
            @RequestParam Integer speed,
            Map<String, Object> model
    ){
        Character updatedCharacter = characterService.updateStats(id, armorClass, exp, speed);
        model.put("character", updatedCharacter);
        return "character";
    }

    @PostMapping(value = "/updateHp/{character_id}")
    public String updateHp(
            @PathVariable("character_id") Long id,
            @RequestParam Integer maxHp,
            @RequestParam Integer curHp,
            @RequestParam Integer tmpHp,
            @RequestParam Integer deathSavesFailed,
            @RequestParam Integer deathSavesPassed,
            @RequestParam Integer currentHitDices,
            Map<String, Object> model
    ){
        Character updatedCharacter = characterService.updateHp(id, maxHp, curHp, tmpHp, deathSavesFailed, deathSavesPassed, currentHitDices);
        model.put("character", updatedCharacter);
        return "character";
    }

    @PostMapping(value = "/updateSkills/{character_id}")
    public String updateSkills(
            @PathVariable("character_id") Long characterId,
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
                characterId,
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
            @PathVariable("character_id") Long characterId,
            @RequestParam("spell_id") Long spellId,
            Map<String, Object> model
    ){
        Character updatedCharacter = characterService.addSpell(characterId, spellId);
        model.put("character", updatedCharacter);
        return "character";
    }

    @PostMapping(value = "/removeSpell/{character_id}")
    public String removeSpell(
            @PathVariable("character_id") Long characterId,
            @RequestParam("spell_id") Long spellId,
            Map<String, Object> model
    ){
        Character updatedCharacter = characterService.deleteSpell(characterId, spellId);
        model.put("character", updatedCharacter);
        return "character";
    }

    @GetMapping(value = "/getSpells/{character_id}")
    public String getSpells(
            @PathVariable("character_id") Long id,
            Map<String, Object> model
    ){
        Set<Spell> spells = characterService.getSpells(id);
        logger.info("Character spells: {}", spells);
        model.put("spells", spells);
        return "character";
    }

    @PostMapping(value = "/addItem/{character_id}")
    public String addItem(
            @PathVariable("character_id") Long characterId,
            @RequestParam("item_id") Long itemId,
            Map<String, Object> model
    ){
        Character updatedCharacter = characterService.addItem(characterId, itemId);
        model.put("character", updatedCharacter);
        return "character";
    }

    @PostMapping(value = "/removeItem/{character_id}")
    public String removeItem(
            @PathVariable("character_id") Long characterId,
            @RequestParam("item_id") Long itemId,
            Map<String, Object> model
    ){
        Character updatedCharacter = characterService.deleteItem(characterId, itemId);
        model.put("character", updatedCharacter);
        return "character";
    }

    @GetMapping(value = "/getItems/{character_id}")
    public String getItems(
            @PathVariable("character_id") Long id,
            Map<String, Object> model
    ){
        Set<Item> items = characterService.getItems(id);
        model.put("items", items);
        return "character";
    }

    @GetMapping(value = "/getRace/{character_id}")
    public String getRace(
            @PathVariable("character_id") Long id,
            Map<String, Object> model
    ){
        Race race = characterService.getCharacterById(id).getRace();
        model.put("race", race);
        return "character";
    }

    @PostMapping(value = "/addRace/{character_id}")
    public String addRace(
            @PathVariable("character_id") Long characterId,
            @RequestParam Long raceId,
            Map<String, Object> model
    ){
        Character character = characterService.addRace(characterId, raceId);
        model.put("character", character);
        return "character";
    }

    @GetMapping(value = "/getCharacterClass/{character_id}")
    public String getCharacterClass(
            @PathVariable("character_id") Long id,
            Map<String, Object> model
    ){
        CharacterClass characterClass = characterService.getCharacterById(id).getCharacterClass();
        model.put("class", characterClass);
        return "character";
    }

    @PostMapping(value = "/addCharacterClass/{character_id}")
    public String addCharacterClass(
            @PathVariable("character_id") Long characterId,
            @RequestParam Long classId,
            Map<String, Object> model
    ){
        Character character = characterService.addRace(characterId, classId);
        model.put("character", character);
        return "character";
    }

    @PostMapping(value = "/updateDescription/{character_id}")
    public String updateDescription(
            @PathVariable("character_id") Long id,
            @RequestParam String name,
            @RequestParam String appearance,
            @RequestParam String background,
            @RequestParam String gender,
            Map<String, Object> model
    ){
        Character character = characterService.updateDescription(id, name, gender, background, appearance);
        model.put("character", character);
        return "character";
    }
}
