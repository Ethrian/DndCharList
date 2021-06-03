package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.Character;
import com.Ethrian.dnd.DndCharList.model.Item;
import com.Ethrian.dnd.DndCharList.model.Spell;
import com.Ethrian.dnd.DndCharList.repo.CharacterRepo;
import com.Ethrian.dnd.DndCharList.repo.SpellRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Service
public class CharacterService {

    private CharacterRepo characterRepo;

    public CharacterService(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    public Character getCharacterById(Long id) {
        return characterRepo.findById(id).orElseThrow();
    }

    public Character newCharacter(
            String name,
            String gender
    ){
        Character character = new Character(name, gender);
        characterRepo.save(character);
        return character;
    }

    public Character updateAbilities(
            Character character,
            Integer STR, Integer DEX, Integer CON,
            Integer INT, Integer WIS, Integer CHA
    ){
        return character;
    }

    public Character updateStats(
            Character character,
            Integer armorClass,
            Integer exp,
            Integer speed
    ){
        return character;
    }

    public Character updateHp(
            Character character,
            Integer maxHp,
            Integer curHp,
            Integer tmpHp,
            Integer deathSavesFailed,
            Integer deathSavesPassed,
            Integer currentHitDices
    ) {
        return character;
    }

    public Character updateSkills(
            Character character,
            Integer athletic,
            Integer acrobatic,
            Integer sleightOfHands,
            Integer stealth,
            Integer investigation,
            Integer history,
            Integer nature,
            Integer arcana,
            Integer religion,
            Integer perception,
            Integer insight,
            Integer survival,
            Integer medicine,
            Integer animalHandling,
            Integer deception,
            Integer intimidation,
            Integer performance,
            Integer persuasion
    ){
        return character;
    }

    public Iterable<Spell> getSpells(Character character) {

        Iterable<Spell> spells = null;
        return spells;
    }

    public Character addSpell(Character character) {

        return character;
    }

    public Iterable<Item> getItems(Character character) {

        Iterable<Item> items = null;
        return items;
    }
    public Character addItem(Character character) {

        return character;
    }
}
