package com.Ethrian.dnd.DndCharList.model;

import javax.persistence.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CharacterClass implements IBonusable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @CollectionTable(name = "class_dice", joinColumns = @JoinColumn(name = "characterClass_id"))
    @Enumerated(EnumType.STRING)
    private Dice hitDice;

    @ManyToMany
    @CollectionTable(name = "class_bonus", joinColumns = @JoinColumn(name = "classBonus_id"))
    private Set<Bonus> classBonuses;

    public CharacterClass() { }

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
}
