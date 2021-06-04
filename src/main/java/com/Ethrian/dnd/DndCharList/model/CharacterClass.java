package com.Ethrian.dnd.DndCharList.model;

import javax.persistence.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CharacterClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer lvl;
    private Boolean dirty;

    @Enumerated(EnumType.STRING)
    private Dice hitDice;

    @ManyToMany
    @CollectionTable(name = "class_bonus", joinColumns = @JoinColumn(name = "character_class_id"))
    private Set<Bonus> classBonuses;

    public CharacterClass() { }

    public CharacterClass(String name, Dice hitDice) {
        this.name = name;
        this.hitDice = hitDice;
        this.dirty = false;
        this.lvl = 1;
    }

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

    public Dice getHitDice() {
        return hitDice;
    }

    public void setHitDice(Dice hitDice) {
        this.hitDice = hitDice;
    }

    public Set<Bonus> getClassBonuses() {
        return classBonuses;
    }

    public void setClassBonuses(Set<Bonus> classBonuses) {
        this.classBonuses = classBonuses;
    }

    public void addBonusToClass(Bonus classBonus) {
        this.classBonuses.add(classBonus);
    }

    public Integer getLvl() {
        return lvl;
    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public Boolean getDirty() {
        return dirty;
    }

    public void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }
}
