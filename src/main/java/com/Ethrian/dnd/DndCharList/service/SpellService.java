package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.Spell;
import com.Ethrian.dnd.DndCharList.repo.BonusRepo;
import com.Ethrian.dnd.DndCharList.repo.SpellRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SpellService {

    private SpellRepo spellRepo;
    private BonusRepo bonusRepo;

    public SpellService(SpellRepo spellRepo, BonusRepo bonusRepo) {
        this.spellRepo = spellRepo;
        this.bonusRepo = bonusRepo;
    }

    public List<Spell> getAllSpells() {
        Iterable<Spell> allSpells = spellRepo.findAll();
        List<Spell> spellList = new java.util.ArrayList<>(Collections.emptyList());
        for (Spell spell : allSpells) {
            if(!spell.getDirty()) spellList.add(spell);
        }
        return spellList;
    }

    public Spell getSpell(Long id) {
        return spellRepo.findById(id).orElseThrow();
    }

    public Spell createSpell(
            String name,
            String description,
            Integer lvl,
            String spellType,
            String castTime,
            String distance,
            String duration,
            Boolean V,
            Boolean S,
            String M
    ) {
        Spell newSpell = new Spell(name, description, lvl, spellType, castTime, distance, duration, V, S, M);
        return spellRepo.save(newSpell);
    }

    public Spell updateName(Long id, String name) {
        Spell spell = spellRepo.findById(id).orElseThrow();
        if(name != null) spell.setName(name);
        return spellRepo.save(spell);
    }

    public Spell updateDescription(Long id, String description) {
        Spell spell = spellRepo.findById(id).orElseThrow();
        if (description != null) spell.setDescription(description);
        return spellRepo.save(spell);
    }

    public Spell updateParams(
            Long id,
            Integer lvl,
            String spellType,
            String castTime,
            String distance,
            String duration,
            Boolean V,
            Boolean S,
            String M
    ) {
        Spell spell = spellRepo.findById(id).orElseThrow();
        if(lvl != null) spell.setLvl(lvl);
        if(spellType != null) spell.setSpellType(spellType);
        if(castTime != null) spell.setCastTime(castTime);
        if(distance != null) spell.setDistance(distance);
        if(duration != null) spell.setDuration(duration);
        if(V != null) spell.setVerbal(V);
        if(S != null) spell.setSomatic(S);
        if(M != null) spell.setMaterial(M);

        return spellRepo.save(spell);
    }

    public void deleteSpell(Long id) {
        spellRepo.deleteById(id);
    }
}
