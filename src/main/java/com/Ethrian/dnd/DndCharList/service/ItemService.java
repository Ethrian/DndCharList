package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.Bonus;
import com.Ethrian.dnd.DndCharList.model.Item;
import com.Ethrian.dnd.DndCharList.repo.BonusRepo;
import com.Ethrian.dnd.DndCharList.repo.ItemRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ItemService {

    private ItemRepo itemRepo;
    private BonusRepo bonusRepo;

    public ItemService(ItemRepo itemRepo, BonusRepo bonusRepo) {
        this.itemRepo = itemRepo;
        this.bonusRepo = bonusRepo;
    }

    public Item getItem(Long id) {
        return itemRepo.findById(id).orElseThrow();
    }

    public List<Item> getAllItems() {
        Iterable<Item> allItems = itemRepo.findAll();
        List<Item> itemList = null;
        for (Item item : allItems) {
            if(!item.getDirty()) itemList.add(item);
        }
        return itemList;
    }

    public Item createItem(
            String name,
            String itemType,
            Integer amount
    ) {
        Item newItem = new Item(name, name, 1.0D, itemType, amount);
        return itemRepo.save(newItem);
    }

    public Item updateName(Long id, String name) {
        Item item = itemRepo.findById(id).orElseThrow();
        item.setName(name);
        return itemRepo.save(item);
    }

    public Item updateDescription(Long id, String description) {
        Item item = itemRepo.findById(id).orElseThrow();
        item.setDescription(description);
        return itemRepo.save(item);
    }

    public Item updateParams(
            Long id,
            String itemType,
            Double weight,
            Integer amount
    ) {
        Item item = itemRepo.findById(id).orElseThrow();
        if(itemType != null) item.setItemType(itemType);
        if(weight != null && weight > 0) item.setWeight(weight);
        if(amount != null && amount >= 0) item.setAmount(amount);
        return itemRepo.save(item);
    }

    public Set<Bonus> getBonuses(Long itemId, Long bonusId){
        Item item = itemRepo.findById(itemId).orElseThrow();
        return item.getItemBonuses();
    }

    public Item addBonus(Long itemId, Long bonusId) {
        Item item = itemRepo.findById(itemId).orElseThrow();
        Bonus searchedBonus = bonusRepo.findById(bonusId).orElseThrow();
        Bonus newBonus = new Bonus(searchedBonus.getName(), searchedBonus.getDescription());
        newBonus.setDirty(true);
        bonusRepo.save(newBonus);
        item.addBonusToItem(newBonus);
        return itemRepo.save(item);
    }

    public Item deleteBonus(Long itemId, Long bonusId) {
        Item item = itemRepo.findById(itemId).orElseThrow();
        Bonus bonus = bonusRepo.findById(bonusId).orElseThrow();
        Set<Bonus> bonuses = item.getItemBonuses();
        bonuses.remove(bonus);
        item.setItemBonuses(bonuses);
        return itemRepo.save(item);
    }

    public void deleteItem(Long id) {
        itemRepo.deleteById(id);
    }
}
