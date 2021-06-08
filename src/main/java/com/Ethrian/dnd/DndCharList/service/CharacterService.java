package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.*;
import com.Ethrian.dnd.DndCharList.model.Character;
import com.Ethrian.dnd.DndCharList.repo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CharacterService {

    private CharacterRepo characterRepo;
    private SpellRepo spellRepo;
    private ItemRepo itemRepo;
    private CharacterClassRepo characterClassRepo;
    private RaceRepo raceRepo;
    private BonusRepo bonusRepo;
    private UserRepo userRepo;

    public CharacterService(
            CharacterRepo characterRepo,
            SpellRepo spellRepo,
            ItemRepo itemRepo,
            CharacterClassRepo characterClassRepo,
            RaceRepo raceRepo,
            BonusRepo bonusRepo,
            UserRepo userRepo
    ) {
        this.characterRepo = characterRepo;
        this.spellRepo = spellRepo;
        this.itemRepo = itemRepo;
        this.characterClassRepo = characterClassRepo;
        this.raceRepo = raceRepo;
        this.bonusRepo = bonusRepo;
        this.userRepo = userRepo;
    }

    public Character getCharacterById(Long id) {
        return characterRepo.findById(id).orElseThrow();
    }

    public List<Character> getCharactersForUser(Long userId) {
        final List<Character> characters = new ArrayList<>();
        User user = userRepo.findById(userId).orElseThrow();
        return characterRepo.findCharactersByUser(user);
    }

    public Character createCharacter(
            User user,
            String name,
            String gender
    ){
        Character character = new Character(name, gender);

        character.setUser(user);

        character.setSTR(10);
        character.setDEX(10);
        character.setCON(10);
        character.setINT(10);
        character.setWIS(10);
        character.setCHA(10);

        character.setAthleticBonus(0);
        character.setAcrotabicBonus(0);
        character.setSleightOfHandsBonus(0);
        character.setStealthBonus(0);
        character.setInvestigationBonus(0);
        character.setNatureBonus(0);
        character.setArcanaBonus(0);
        character.setReligionBonus(0);
        character.setHistoryBonus(0);
        character.setPerceptionBonus(0);
        character.setInsightBonus(0);
        character.setSurvivalBonus(0);
        character.setMedicineBonus(0);
        character.setAnimalHandlingBonus(0);
        character.setDecetpionBonus(0);
        character.setIntimidationBonus(0);
        character.setPerformanceBonus(0);
        character.setPersuationBonus(0);

        character.setArmorClass(10);
        character.setExp(0);
        character.setSpeed(30);

        character.setMaxHP(0);
        character.setCurHP(0);
        character.setTmpHP(0);
        character.setDeathSavesPassed(0);
        character.setDeathSavesFailed(0);
        character.setCurHitDices(1);

        return characterRepo.save(character);
    }

    public Character updateAbilities(
            Long id,
            Integer STR, Integer DEX, Integer CON,
            Integer INT, Integer WIS, Integer CHA
    ){
        Character character = characterRepo.findById(id).orElseThrow();
        if(STR != null && STR > 0) character.setSTR(STR);
        if(DEX != null && DEX > 0){
            character.setDEX(DEX);
            character.setInitiative(((Integer) (DEX - 10) / 2) + 10);
        }
        if(CON != null && CON > 0) character.setCON(CON);
        if(INT != null && INT > 0) character.setINT(INT);
        if(WIS != null && WIS > 0) character.setWIS(WIS);
        if(CHA != null && CHA > 0) character.setCHA(CHA);
        characterRepo.save(character);
        return character;
    }

    public Character updateStats(
            Long id,
            Integer armorClass,
            Integer exp,
            Integer speed
    ){
        Character character = characterRepo.findById(id).orElseThrow();
        if(armorClass != null) {
            if(armorClass == 0){
                character.setArmorClass((character.getDEX() - 10) / 2);
            } else if(armorClass > 0) character.setArmorClass(armorClass);
        }
        if(exp != null && exp > 0) character.setExp(exp);
        if(speed != null && speed > 0) character.setSpeed(speed);

        return characterRepo.save(character);
    }

    public Character updateDescription(
            Long id,
            String name,
            String gender,
            String background,
            String appearance
    ){
        Character character = characterRepo.findById(id).orElseThrow();
        if(name != null) character.setName(name);
        if(gender != null) character.setGender(gender);
        if(background != null) character.setBackground(background);
        if(appearance != null) character.setAppearence(appearance);
        return characterRepo.save(character);
    }

    public Character updateHp(
            Long id,
            Integer maxHp,
            Integer curHp,
            Integer tmpHp,
            Integer deathSavesFailed,
            Integer deathSavesPassed,
            Integer currentHitDices
    ) {
        Character character = characterRepo.findById(id).orElseThrow();
        if(maxHp != null && maxHp > 0) character.setMaxHP(maxHp);
        if(curHp != null && curHp > 0 && curHp <= character.getMaxHP()) character.setCurHP(curHp);
        if(tmpHp != null && tmpHp > 0) character.setTmpHP(tmpHp);
        if(deathSavesFailed != null && deathSavesFailed >= 0) {
            if(deathSavesFailed >= 3) character.setDeathSavesFailed(3);
            else character.setDeathSavesFailed(deathSavesFailed);
        }
        if(deathSavesPassed != null && deathSavesPassed >= 0) {
            if(deathSavesPassed >= 3) {
                character.setDeathSavesPassed(0);
                character.setDeathSavesFailed(0);
                character.setCurHP(1);
            } else character.setDeathSavesPassed(deathSavesPassed);
        }
        if(currentHitDices != null) {
            if(character.getCharacterClass() != null && currentHitDices >= 0) {
                if(currentHitDices <= character.getCharacterClass().getLvl()) character.setCurHitDices(currentHitDices);
                else character.setCurHitDices(character.getCharacterClass().getLvl());
            } else character.setCurHitDices(0);
        }

        return characterRepo.save(character);
    }

    public Character updateSkills(
            Long id,
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
        Character character = characterRepo.findById(id).orElseThrow();
        if(athletic != null) character.setAthleticBonus(athletic);
        if(acrobatic != null) character.setAcrotabicBonus(acrobatic);
        if(sleightOfHands != null) character.setSleightOfHandsBonus(sleightOfHands);
        if(stealth != null) character.setStealthBonus(stealth);
        if(investigation != null) character.setInvestigationBonus(investigation);
        if(history != null) character.setHistoryBonus(history);
        if(nature != null) character.setNatureBonus(nature);
        if(arcana != null) character.setArcanaBonus(arcana);
        if(religion != null) character.setReligionBonus(religion);
        if(perception != null) character.setPerceptionBonus(perception);
        if(insight != null) character.setInsightBonus(insight);
        if(survival != null) character.setSurvivalBonus(survival);
        if(medicine != null) character.setMedicineBonus(medicine);
        if(animalHandling != null) character.setAnimalHandlingBonus(animalHandling);
        if(deception != null) character.setDecetpionBonus(deception);
        if(intimidation != null) character.setIntimidationBonus(intimidation);
        if(performance != null) character.setPerformanceBonus(performance);
        if(persuasion != null) character.setPersuationBonus(persuasion);
        return characterRepo.save(character);
    }

    public Set<Spell> getSpells(Long id) {
        Character character = characterRepo.findById(id).orElseThrow();
        return character.getSpells();
    }

    public Character addSpell(Long characterId, Long spellId) {

        Character character = characterRepo.findById(characterId).orElseThrow();
        Spell searchedSpell = spellRepo.findById(spellId).orElseThrow();

        Spell newSpell = new Spell(
             searchedSpell.getName(),
             searchedSpell.getDescription(),
             searchedSpell.getLvl(),
             searchedSpell.getSpellType(),
             searchedSpell.getCastTime(),
             searchedSpell.getDistance(),
             searchedSpell.getDuration(),
             searchedSpell.getVerbal(),
             searchedSpell.getSomatic(),
             searchedSpell.getMaterial()
        );
        newSpell.setDirty(true);
        spellRepo.save(newSpell);
        character.addSpellToList(newSpell);
        return characterRepo.save(character);
    }

    public Character deleteSpell(Long characterId, Long spellId) {

        Character character = characterRepo.findById(characterId).orElseThrow();
        Set<Spell> spellbook = character.getSpells();
        Spell spell = spellRepo.findById(spellId).orElseThrow();
        spellbook.remove(spell);
        character.setSpells(spellbook);
        characterRepo.save(character);
        return character;
    }

    public Set<Item> getItems(Long id) {

        Character character = characterRepo.findById(id).orElseThrow();
        return character.getItems();
    }
    public Character addItem(Long characterId, Long itemId) {
        Character character = characterRepo.findById(characterId).orElseThrow();
        Item searchedItem = itemRepo.findById(itemId).orElseThrow();
        Item item = new Item(
                searchedItem.getName(),
                searchedItem.getDescription(),
                searchedItem.getWeight(),
                searchedItem.getItemType(),
                searchedItem.getAmount()
        );
        item.setDirty(true);
        itemRepo.save(item);
        character.addItemToList(item);
        return characterRepo.save(character);
    }


    public Character deleteItem(Long characterId, Long itemId) {

        Character character = characterRepo.findById(characterId).orElseThrow();
        Set<Item> inventory = character.getItems();
        Item item = itemRepo.findById(itemId).orElseThrow();
        inventory.remove(item);
        character.setItems(inventory);
        characterRepo.save(character);
        return character;
    }

    public Character addClass(Long characterId, Long classId) {
        Character character = characterRepo.findById(characterId).orElseThrow();
        CharacterClass searchedClass = characterClassRepo.findById(classId).orElseThrow();
        CharacterClass characterClass = new CharacterClass(searchedClass.getName(), searchedClass.getHitDice());
        characterClass.setDirty(true);
        characterClassRepo.save(characterClass);
        character.setCharacterClass(characterClass);
        return characterRepo.save(character);
    }

    public Character addRace(Long characterId, Long raceId) {
        Character character = characterRepo.findById(characterId).orElseThrow();
        Race searchedRace = raceRepo.findById(raceId).orElseThrow();
        Race race = new Race(searchedRace.getName(), searchedRace.getDescription());
        race.setDirty(true);
        raceRepo.save(race);
        character.setRace(race);
        return characterRepo.save(character);
    }

    public Set<Bonus> getBonuses(Long characterId, Long bonusId){
        Character character = characterRepo.findById(characterId).orElseThrow();
        return character.getOtherBonuses();
    }

    public Character addBonus(Long characterId, Long bonusId) {
        Character character = characterRepo.findById(characterId).orElseThrow();
        Bonus searchedBonus = bonusRepo.findById(bonusId).orElseThrow();
        Bonus newBonus = new Bonus(searchedBonus.getName(), searchedBonus.getDescription());
        newBonus.setDirty(true);
        bonusRepo.save(newBonus);
        character.addBonusToList(newBonus);
        return characterRepo.save(character);
    }

    public Character deleteBonus(Long characterId, Long bonusId) {
        Character character = characterRepo.findById(characterId).orElseThrow();
        Bonus bonus = bonusRepo.findById(bonusId).orElseThrow();
        Set<Bonus> bonuses = character.getOtherBonuses();
        bonuses.remove(bonus);
        character.setOtherBonuses(bonuses);
        return characterRepo.save(character);
    }

    public void deleteCharacter(Long id, String name){
        Character character = characterRepo.findById(id).orElseThrow();
        if(character.getName().equals(name)) characterRepo.deleteById(id);
    }
}
