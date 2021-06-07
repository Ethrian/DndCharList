package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.Bonus;
import com.Ethrian.dnd.DndCharList.model.Item;
import com.Ethrian.dnd.DndCharList.model.Race;
import com.Ethrian.dnd.DndCharList.model.Spell;
import com.Ethrian.dnd.DndCharList.repo.BonusRepo;
import com.Ethrian.dnd.DndCharList.repo.RaceRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class RaceService {

    private RaceRepo raceRepo;
    private BonusRepo bonusRepo;

    public RaceService(RaceRepo raceRepo, BonusRepo bonusRepo) {
        this.raceRepo = raceRepo;
        this.bonusRepo = bonusRepo;
    }

    public Race getRace(Long id){
        return raceRepo.findById(id).orElseThrow();
    }

    public List<Race> getAllRaces(){
        Iterable<Race> allRaces = raceRepo.findAll();
        List<Race> raceList = new java.util.ArrayList<>(Collections.emptyList());
        for (Race race : allRaces) {
            if(!race.getDirty()) raceList.add(race);
        }
        return raceList;
    }

    public Race createRace(String name, String description) {
        Race newRace = new Race(name, description);
        return raceRepo.save(newRace);
    }

    public Race updateName(Long id, String name){
        Race race = raceRepo.findById(id).orElseThrow();
        race.setName(name);
        return raceRepo.save(race);
    }

    public Race updateDescription(Long id, String description){
        Race race = raceRepo.findById(id).orElseThrow();
        race.setDescription(description);
        return raceRepo.save(race);
    }

    public Set<Bonus> getBonuses(Long raceId) {
        Race race = raceRepo.findById(raceId).orElseThrow();
        return race.getRacialBonuses();
    }

    public Race addBonus(Long raceId, Long bonusId) {
        Race race = raceRepo.findById(raceId).orElseThrow();
        Bonus searchedBonus = bonusRepo.findById(bonusId).orElseThrow();
        Bonus newBonus = new Bonus(searchedBonus.getName(), searchedBonus.getDescription());
        newBonus.setDirty(true);
        race.addBonusToRace(newBonus);
        return raceRepo.save(race);
    }

    public Race deleteBonus(Long raceId, Long bonusId) {
        Race race = raceRepo.findById(raceId).orElseThrow();
        Bonus bonus = bonusRepo.findById(bonusId).orElseThrow();
        Set<Bonus> bonuses = race.getRacialBonuses();
        bonuses.remove(bonus);
        race.setRacialBonuses(bonuses);
        return raceRepo.save(race);
    }

    public void deleteRace(Long id){
        raceRepo.deleteById(id);
    }
}
