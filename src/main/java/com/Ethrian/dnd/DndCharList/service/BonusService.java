package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.Bonus;
import com.Ethrian.dnd.DndCharList.repo.BonusRepo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BonusService {

    private BonusRepo bonusRepo;

    public BonusService (BonusRepo bonusRepo) {
        this.bonusRepo = bonusRepo;
    }

    public Bonus getBonus(Long id) {
        return bonusRepo.findById(id).orElseThrow();
    }

    public List<Bonus> getAllBonuses() {
        Iterable<Bonus> allBonuses = bonusRepo.findAll();
        List<Bonus> bonusList = null;
        for (Bonus bonus : allBonuses) {
             if(!bonus.getDirty()) bonusList.add(bonus);
        }
        return bonusList;
    }

    public Bonus createBonus(
            String name,
            String description
    ){
        Bonus newBonus = new Bonus(name, description);
        return bonusRepo.save(newBonus);
    }

    public Bonus updateBonusName(
            Long id,
            String name
    ) {
        Bonus bonus = bonusRepo.findById(id).orElseThrow();
        if(name != null ) bonus.setName(name);
        return bonusRepo.save(bonus);
    }

    public Bonus updateBonusDescription(
            Long id,
            String description
    ) {
        Bonus bonus = bonusRepo.findById(id).orElseThrow();
        if(description != null) bonus.setDescription(description);
        return bonusRepo.save(bonus);
    }

    public void deleteBonus(Long id){
        bonusRepo.deleteById(id);
    }
}
