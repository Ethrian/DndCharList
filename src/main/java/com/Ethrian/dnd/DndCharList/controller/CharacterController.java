package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Character;
import com.Ethrian.dnd.DndCharList.model.*;
import com.Ethrian.dnd.DndCharList.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class CharacterController {

    private final Logger logger = LoggerFactory.getLogger(CharacterController.class);

    private CharacterService characterService;
    private final UserService userService;
    private final SpellService spellService;
    private final ItemService itemService;
    private final RaceService raceService;
    private final CharacterClassService characterClassService;

    public CharacterController(
            CharacterService characterService,
            UserService userService,
            SpellService spellService,
            ItemService itemService,
            RaceService raceService,
            CharacterClassService characterClassService
    ) {
        this.characterService = characterService;
        this.userService = userService;
        this.spellService = spellService;
        this.itemService = itemService;
        this.raceService = raceService;
        this.characterClassService = characterClassService;
    }

    @GetMapping("/character/{id}")
    public ModelAndView getCharacter(@PathVariable("id") Long id){
        Character character = characterService.getCharacterById(id);
        ModelAndView model = new ModelAndView("character");
        model.addObject("character", character);
        return model;
    }

    @PostMapping(value = "/character/new")
    public ModelAndView createCharacter(
            Principal principal,
            @RequestParam String name,
            @RequestParam String gender
    ){
        User user = UserPrincipal.getUser(principal);
        characterService.createCharacter(user, name, gender);
        return new ModelAndView("redirect:/profile");
    }

    @PostMapping(value = "/character/{id}/updateAbilities")
    public ModelAndView updateAbilities(
            @PathVariable("id") Long id,
            @RequestParam Integer STR, @RequestParam Integer DEX,
            @RequestParam Integer CON, @RequestParam Integer INT,
            @RequestParam Integer WIS, @RequestParam Integer CHA,
            Map<String, Object> model
    ){
        characterService.updateAbilities(id, STR, DEX, CON, INT, WIS, CHA);
        return new ModelAndView("redirect:/character/" + id);
    }

    @PostMapping(value = "/character/{character_id}/updateStats")
    public ModelAndView updateStats(
            @PathVariable("character_id") Long id,
            @RequestParam Integer armorClass,
            @RequestParam Integer exp,
            @RequestParam Integer speed
    ){
        characterService.updateStats(id, armorClass, exp, speed);
        return new ModelAndView("redirect:/character/" + id);
    }

    @PostMapping(value = "/character/{id}/updateHp")
    public ModelAndView updateHp(
            @PathVariable("id") Long id,
            @RequestParam Integer maxHp,
            @RequestParam Integer curHp,
            @RequestParam Integer tmpHp,
            @RequestParam Integer deathSavesFailed,
            @RequestParam Integer deathSavesPassed,
            @RequestParam Integer currentHitDices
    ){
        characterService.updateHp(id, maxHp, curHp, tmpHp, deathSavesFailed, deathSavesPassed, currentHitDices);
        return new ModelAndView("redirect:/character/" + id);
    }

    @PostMapping(value = "/character/{id}/updateSkills")
    public ModelAndView updateSkills(
            @PathVariable("id") Long id,
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
            @RequestParam Integer persuasion
    ) {
        characterService.updateSkills(
                id,
                athletic,
                acrobatic, sleightOfHands, stealth,
                investigation, history, nature, arcana, religion,
                perception, insight, survival, medicine, animalHandling,
                deception, intimidation, performance, persuasion
        );

        return new ModelAndView("redirect:/character/" + id);
    }

    @PostMapping(value = "/character/{character_id}/addSpell")
    public ModelAndView addSpell(
            @PathVariable("character_id") Long characterId,
            @RequestParam("spell_id") Long spellId
    ){
        characterService.addSpell(characterId, spellId);
        return new ModelAndView("redirect:/character/" + characterId + "/spells");
    }

    @PostMapping(value = "/character/{character_id}/spell/delete/{spell_id}")
    public ModelAndView removeSpell(
            @PathVariable("character_id") Long characterId,
            @PathVariable("spell_id") Long spellId
    ){
        Character updatedCharacter = characterService.deleteSpell(characterId, spellId);
        ModelAndView model = new ModelAndView("redirect:/character/" + characterId + "/spells");
        Set<Spell> spellList = characterService.getSpells(characterId);
        model.addObject("character", updatedCharacter);
        model.addObject("spells", spellList);
        return model;
    }

    @GetMapping(value = "/character/{character_id}/spells")
    public ModelAndView getSpells(
            @PathVariable("character_id") Long id
    ){
        Set<Spell> spells = characterService.getSpells(id);
        ModelAndView model = new ModelAndView("characterSpells");
        model.addObject("spells", spells);
        model.addObject("characterId", id);
        return model;
    }

    @GetMapping(value = "/character/{character_id}/moreSpells")
    public ModelAndView getMoreSpellsForCharacter(@PathVariable("character_id") Long id) {
        List<Spell> spells = spellService.getAllSpells();
        ModelAndView model = new ModelAndView("spells");
        model.addObject("spells", spells);
        model.addObject("characterId", id);
        return model;
    }

    @PostMapping(value = "/character/{character_id}/addItem")
    public ModelAndView addItem(
            @PathVariable("character_id") Long characterId,
            @RequestParam("item_id") Long itemId
    ){
        characterService.addItem(characterId, itemId);
        return new ModelAndView("redirect:/character/" + characterId + "/items");
    }

    @PostMapping(value = "/character/{character_id}/item/delete/{item_id}")
    public ModelAndView removeItem(
            @PathVariable("character_id") Long characterId,
            @PathVariable("item_id") Long itemId
    ){
        Character updatedCharacter = characterService.deleteItem(characterId, itemId);
        ModelAndView model = new ModelAndView("redirect:/character/" + characterId + "/items");
        Set<Item> itemList = characterService.getItems(characterId);
        model.addObject("character", updatedCharacter);
        model.addObject("items", itemList);
        return model;
    }

    @GetMapping(value = "/character/{character_id}/items")
    public ModelAndView getItems(
            @PathVariable("character_id") Long id
    ){
        Set<Item> items = characterService.getItems(id);
        ModelAndView model = new ModelAndView("characterItems");
        model.addObject("items", items);
        model.addObject("characterId", id);
        return model;
    }

    @GetMapping(value = "/character/{character_id}/moreItems")
    public ModelAndView getMoreItemsForCharacter(@PathVariable("character_id") Long id) {
        List<Item> items = itemService.getAllItems();
        ModelAndView model = new ModelAndView("items");
        model.addObject("items", items);
        model.addObject("characterId", id);
        return model;
    }
//----
//    @GetMapping(value = "/character/{character_id}/race")
//    public String getRace(
//            @PathVariable("character_id") Long id,
//            Map<String, Object> model
//    ){
//        Race race = characterService.getCharacterById(id).getRace();
//        model.put("race", race);
//        return new ModelAndView("redirect:/character/" + id + "/race");
//    }

    @PostMapping(value = "/character/{character_id}/addRace")
    public ModelAndView addRace(
            @PathVariable("character_id") Long characterId,
            @RequestParam("race_id") Long raceId
    ){
        characterService.addRace(characterId, raceId);
        return new ModelAndView("redirect:/character/" + characterId);
    }

    @GetMapping(value = "/character/{character_id}/changeRace")
    public ModelAndView changeCharacterRace(@PathVariable("character_id") Long id) {
        List<Race> races = raceService.getAllRaces();
        ModelAndView model = new ModelAndView("charRace");
        model.addObject("races", races);
        model.addObject("characterId", id);
        return model;
    }
    //--------
    @PostMapping(value = "/character/{character_id}/addClass")
    public ModelAndView addClass(
            @PathVariable("character_id") Long characterId,
            @RequestParam("class_id") Long classId
    ){
        characterService.addClass(characterId, classId);
        return new ModelAndView("redirect:/character/" + characterId);
    }

    @GetMapping(value = "/character/{character_id}/changeClass")
    public ModelAndView changeCharacterClass(@PathVariable("character_id") Long id) {
        List<CharacterClass> characterClasses = characterClassService.getAllClasses();
        ModelAndView model = new ModelAndView("charClass");
        model.addObject("characterClasses", characterClasses);
        model.addObject("characterId", id);
        return model;
    }

//    @GetMapping(value = "/getCharacterClass/{character_id}")
//    public String getCharacterClass(
//            @PathVariable("character_id") Long id,
//            Map<String, Object> model
//    ){
//        CharacterClass characterClass = characterService.getCharacterById(id).getCharacterClass();
//        model.put("class", characterClass);
//        return "character";
//    }

//    @PostMapping(value = "/addCharacterClass/{character_id}")
//    public String addCharacterClass(
//            @PathVariable("character_id") Long characterId,
//            @RequestParam Long classId,
//            Map<String, Object> model
//    ){
//        Character character = characterService.addRace(characterId, classId);
//        model.put("character", character);
//        return "character";
//    }

    @PostMapping(value = "/character/{character_id}/description")
    public ModelAndView updateDescription(
            @PathVariable("character_id") Long id,
            @RequestParam String name,
            @RequestParam String appearance,
            @RequestParam String background,
            @RequestParam String gender,
            Map<String, Object> model
    ){
        characterService.updateDescription(id, name, gender, background, appearance);
        return new ModelAndView("redirect:/character/" + id);
    }

    @PostMapping("/character/delete/{id}")
    public ModelAndView deleteCharacter(@PathVariable("id") Long id){
        characterService.deleteCharacter(id);
        return new ModelAndView("redirect:/profile");
    }
}
