package com.Ethrian.dnd.DndCharList.repo;

import com.Ethrian.dnd.DndCharList.model.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepo extends CrudRepository<Inventory, Long> {
}
