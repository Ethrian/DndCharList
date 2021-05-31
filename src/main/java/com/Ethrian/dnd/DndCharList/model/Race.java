package com.Ethrian.dnd.DndCharList.model;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Race implements IBonusable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String desc;

    @ManyToMany
    @CollectionTable(name = "race_bonus", joinColumns = @JoinColumn(name = "bonus_id"))
    private Set<Bonus> racialBonuses;

    public Race() { }

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

    public Set<Bonus> getRacialBonuses() {
        return racialBonuses;
    }

    public void setRacialBonuses(Set<Bonus> racialBonuses) {
        this.racialBonuses = racialBonuses;
    }
}
