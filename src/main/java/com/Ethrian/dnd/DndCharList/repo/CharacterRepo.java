package com.Ethrian.dnd.DndCharList.repo;

import com.Ethrian.dnd.DndCharList.model.Character;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharacterRepo extends CrudRepository<Character, Long> {


}
