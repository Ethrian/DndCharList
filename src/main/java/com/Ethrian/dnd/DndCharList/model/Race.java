package com.Ethrian.dnd.DndCharList.model;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private Boolean dirty;

    @ManyToMany
    @CollectionTable(name = "race_bonus", joinColumns = @JoinColumn(name = "race_id"))
    private Set<Bonus> racialBonuses;

    public Race() { }

    public Race(String name, String description) {
        this.name = name;
        this.description = description;
        this.dirty = false;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public Set<Bonus> getRacialBonuses() {
        return racialBonuses;
    }

    public void setRacialBonuses(Set<Bonus> racialBonuses) {
        this.racialBonuses = racialBonuses;
    }

    public void addBonusToRace(Bonus racialBonus) {
        this.racialBonuses.add(racialBonus);
    }

    public Boolean getDirty() {
        return dirty;
    }

    public void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }
}
