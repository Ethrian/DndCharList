package com.Ethrian.dnd.DndCharList.model;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Character {

    private Long id;
    private String name;
    private Race race;
    private CharacterClass characterClass;
    private String background;
    private Integer exp;
    private Integer maxHP;
    private Integer curHP;
    private Integer tmpHP;
    private Integer armorClass;
    private Integer initiative;
    private Integer speed;
    private Integer deathSavesFailed;
    private Integer deathSavesPassed;
    private List<Pair<Item, Integer>> inventory;
    private Integer cp;
    private Integer sp;
    private Integer gp;
    private Integer pp;
    private Map<SpellLevel, Integer> spellSlots;
    private Set<Spell> spellsList;
    private Integer profBonus;

    private Integer STR;
    private Integer DEX;
    private Integer CON;
    private Integer INT;
    private Integer WIS;
    private Integer CHA;

    private Map<Skill, Pair<Ability, Integer>> skills;

    private Set<Effect> effects;


    private Set<Bonus> otherBonuses;
}
