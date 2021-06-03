package com.Ethrian.dnd.DndCharList.repo;

import com.Ethrian.dnd.DndCharList.model.Spell;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpellRepo extends CrudRepository<Spell, Long> {
//    public List<Spell>
}
