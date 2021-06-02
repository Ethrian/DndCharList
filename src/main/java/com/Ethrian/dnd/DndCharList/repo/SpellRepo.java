package com.Ethrian.dnd.DndCharList.repo;

import com.Ethrian.dnd.DndCharList.model.Spell;
import org.springframework.data.repository.CrudRepository;

public interface SpellRepo extends CrudRepository<Spell, Long> {
}
