package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.repo.SpellRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpellService {

    @Autowired
    private SpellRepo spellRepo;
}
