package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.Bonus;
import com.Ethrian.dnd.DndCharList.model.CharacterClass;
import com.Ethrian.dnd.DndCharList.model.Dice;
import com.Ethrian.dnd.DndCharList.model.Item;
import com.Ethrian.dnd.DndCharList.repo.BonusRepo;
import com.Ethrian.dnd.DndCharList.repo.CharacterClassRepo;
import com.Ethrian.dnd.DndCharList.repo.CharacterRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class CharacterClassService {

    private CharacterClassRepo characterClassRepo;
    private BonusRepo bonusRepo;

    public CharacterClassService(CharacterClassRepo characterClassRepo, BonusRepo bonusRepo){
        this.characterClassRepo = characterClassRepo;
        this.bonusRepo = bonusRepo;
    }

    public CharacterClass getCharacterClass(Long id) {
        return characterClassRepo.findById(id).orElseThrow();
    }

    public List<CharacterClass> getAllClasses() {
        Iterable<CharacterClass> allClasses = characterClassRepo.findAll();
        List<CharacterClass> characterClassList = new java.util.ArrayList<>(Collections.emptyList());
        for (CharacterClass characterClass : allClasses) {
            if(!characterClass.getDirty()) characterClassList.add(characterClass);
        }
        return characterClassList;
    }

    public CharacterClass createCharacterClass(String name, Dice hitDice){
        CharacterClass characterClass = new CharacterClass(name, hitDice);
        return characterClassRepo.save(characterClass);
    }

    public CharacterClass updateName(Long id, String name) {
        CharacterClass characterClass = characterClassRepo.findById(id).orElseThrow();
        characterClass.setName(name);
        return characterClassRepo.save(characterClass);
    }

    public CharacterClass updateLvl(Long id, Integer lvl) {
        CharacterClass characterClass = characterClassRepo.findById(id).orElseThrow();
        characterClass.setLvl(lvl);
        return characterClassRepo.save(characterClass);
    }

    public CharacterClass updateDice(Long id, Dice dice) {
        CharacterClass characterClass = characterClassRepo.findById(id).orElseThrow();
        characterClass.setHitDice(dice);
        return characterClassRepo.save(characterClass);
    }


    public Set<Bonus> getBonuses(Long classId, Long bonusId){
        CharacterClass characterClass = characterClassRepo.findById(classId).orElseThrow();
        return characterClass.getClassBonuses();
    }

    public CharacterClass addBonus(Long classId, Long bonusId) {
        CharacterClass characterClass = characterClassRepo.findById(classId).orElseThrow();
        Bonus searchedBonus = bonusRepo.findById(bonusId).orElseThrow();
        Bonus newBonus = new Bonus(searchedBonus.getName(), searchedBonus.getDescription());
        newBonus.setDirty(true);
        bonusRepo.save(newBonus);
        characterClass.addBonusToClass(newBonus);
        return characterClassRepo.save(characterClass);
    }

    public CharacterClass deleteBonus(Long classId, Long bonusId) {
        CharacterClass characterClass = characterClassRepo.findById(classId).orElseThrow();
        Bonus bonus = bonusRepo.findById(bonusId).orElseThrow();
        Set<Bonus> bonuses = characterClass.getClassBonuses();
        bonuses.remove(bonus);
        characterClass.setClassBonuses(bonuses);
        return characterClassRepo.save(characterClass);
    }

    public void deleteCharacterClass(Long id){
        characterClassRepo.deleteById(id);
    }
}
