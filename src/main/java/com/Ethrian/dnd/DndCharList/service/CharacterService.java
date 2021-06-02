package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.Character;
import com.Ethrian.dnd.DndCharList.repo.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepo characterRepo;

    public Character updateAbilities(
            Character character,
            Integer STR, Integer DEX, Integer CON,
            Integer INT, Integer WIS, Integer CHA
    ){

    }

    public Character updateStats(
            Character character,
            Integer armorClass,
            Integer exp,
            Integer initiative,
            Integer speed,
            Integer profBonus
    ){

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

    }

    public Character updateSkills(
            Character character,
            Integer athletic,
            Integer acrotabic,
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
            Integer decetpion,
            Integer intimidation,
            Integer performance,
            Integer persuation
    ){

    }

    public Character updateSpellSlots(
            Character character,
            Integer lvl1, Integer lvl2, Integer lvl3,
            Integer lvl4, Integer lvl5, Integer lvl6,
            Integer lvl7, Integer lvl8, Integer lvl9
    ) {

    }
}
