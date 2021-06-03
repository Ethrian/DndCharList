package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.Character;
import com.Ethrian.dnd.DndCharList.model.Item;
import com.Ethrian.dnd.DndCharList.model.Spell;
import com.Ethrian.dnd.DndCharList.repo.CharacterRepo;
import com.Ethrian.dnd.DndCharList.repo.SpellRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CharacterService {

    private CharacterRepo characterRepo;
    private SpellRepo spellRepo;

    public CharacterService(CharacterRepo characterRepo, SpellRepo spellRepo) {
        this.characterRepo = characterRepo;
        this.spellRepo = spellRepo;
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
            Long characterId,
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
        Character character = characterRepo.findById(characterId).orElseThrow();
        // todo: change character params and save
        character.setStealthBonus(stealth);
        // todo: same for all params
        return characterRepo.save(character);
    }

    public Set<Spell> getSpells(Long id) {
        Character character = characterRepo.findById(id).orElseThrow();
        Set<Spell> spells = character.getSpells();
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
