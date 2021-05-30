package com.Ethrian.dnd.DndCharList.model;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bonus {

    private Long id;
    private String name;
    private String desc;

    private Integer STR;
    private Integer DEX;
    private Integer CON;
    private Integer INT;
    private Integer WIS;
    private Integer CHA;

    private Integer HP;
    private Integer armorClass;
    private Integer initiative;
    private Integer profBonus;

    private Pair<Dice, Integer> damageDice;
    private Integer damageBonus;
    private DamageType damageType;
    private DamageType damageTypeB;

    private Set<DamageType> resistances;
    private Set<DamageType> immunities;

    private Set<Spell> spells;
    private Map<Skill, Integer> skillsBonuses;
}
