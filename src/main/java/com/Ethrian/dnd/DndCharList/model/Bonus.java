package com.Ethrian.dnd.DndCharList.model;

import javafx.util.Pair;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import java.util.Map;
import java.util.Set;

@Entity
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany
    private Set<DamageType> resistances;
    @ManyToMany
    private Set<DamageType> immunities;

    @ManyToMany
    private Set<Spell> spells;
    @ManyToMany
    private Map<Skill, Integer> skillsBonuses;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public Map<Skill, Integer> getSkillsBonuses() {
        return skillsBonuses;
    }

    public void setSkillsBonuses(Map<Skill, Integer> skillsBonuses) {
        this.skillsBonuses = skillsBonuses;
    }
}
