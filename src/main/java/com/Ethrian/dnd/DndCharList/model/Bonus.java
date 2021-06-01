package com.Ethrian.dnd.DndCharList.model;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

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

    @ElementCollection(targetClass = DamageType.class)
    @CollectionTable(name = "bonus_resistance", joinColumns = @JoinColumn(name = "resistance_id"))
    @Enumerated(EnumType.STRING)
    private Set<DamageType> resistances;

    @ElementCollection(targetClass = DamageType.class)
    @CollectionTable(name = "bonus_immunity", joinColumns = @JoinColumn(name = "immunity_id"))
    @Enumerated(EnumType.STRING)
    private Set<DamageType> immunities;

    @ManyToMany
    @CollectionTable(name = "bonus_spell", joinColumns = @JoinColumn(name = "spell_id"))
    private Set<Spell> spells;
    @ManyToMany
    @CollectionTable(name = "bonus_skill", joinColumns = @JoinColumn(name = "skillsBonus_id"))
    private Set<CharacterSkill> skillBonuses;

    public Bonus() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public Integer getSTR() {
        return STR;
    }

    public void setSTR(Integer STR) {
        this.STR = STR;
    }

    public Integer getDEX() {
        return DEX;
    }

    public void setDEX(Integer DEX) {
        this.DEX = DEX;
    }

    public Integer getCON() {
        return CON;
    }

    public void setCON(Integer CON) {
        this.CON = CON;
    }

    public Integer getINT() {
        return INT;
    }

    public void setINT(Integer INT) {
        this.INT = INT;
    }

    public Integer getWIS() {
        return WIS;
    }

    public void setWIS(Integer WIS) {
        this.WIS = WIS;
    }

    public Integer getCHA() {
        return CHA;
    }

    public void setCHA(Integer CHA) {
        this.CHA = CHA;
    }

    public Integer getHP() {
        return HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public Integer getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getProfBonus() {
        return profBonus;
    }

    public void setProfBonus(Integer profBonus) {
        this.profBonus = profBonus;
    }

    public Set<DamageType> getResistances() {
        return resistances;
    }

    public void setResistances(Set<DamageType> resistances) {
        this.resistances = resistances;
    }

    public Set<DamageType> getImmunities() {
        return immunities;
    }

    public void setImmunities(Set<DamageType> immunities) {
        this.immunities = immunities;
    }

    public Set<Spell> getSpells() {
        return spells;
    }

    public void setSpells(Set<Spell> spells) {
        this.spells = spells;
    }

    public Set<CharacterSkill> getSkillsBonuses() {
        return skillBonuses;
    }

    public void setSkillsBonuses(Set<CharacterSkill> skillsBonuses) {
        this.skillBonuses = skillsBonuses;
    }
}
