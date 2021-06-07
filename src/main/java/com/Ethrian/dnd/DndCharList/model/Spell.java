package com.Ethrian.dnd.DndCharList.model;

import javax.persistence.Id;

import javax.persistence.*;

@Entity
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private Integer lvl;
    private String spellType;

    private String castTime;
    private String distance;
    private String duration;

    private Boolean verbal;
    private Boolean somatic;
    private String material;
    private Boolean dirty;


    public Spell() { }

    public Spell(String name, String description, Integer lvl, String spellType, String castTime, String distance, String duration, Boolean verbal, Boolean somatic, String material) {
        this.name = name;
        this.description = description;
        this.lvl = lvl;
        this.spellType = spellType;
        this.castTime = castTime;
        this.distance = distance;
        this.duration = duration;
        this.verbal = verbal;
        this.somatic = somatic;
        this.material = material;
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

    public Integer getLvl() {
        return lvl;
    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public String getSpellType() {
        return spellType;
    }

    public void setSpellType(String spellType) {
        this.spellType = spellType;
    }

    public String getCastTime() {
        return castTime;
    }

    public void setCastTime(String castTime) {
        this.castTime = castTime;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Boolean getVerbal() {
        return verbal;
    }

    public void setVerbal(Boolean verbal) {
        this.verbal = verbal;
    }

    public Boolean getSomatic() {
        return somatic;
    }

    public void setSomatic(Boolean somatic) {
        this.somatic = somatic;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Boolean getDirty() {
        return dirty;
    }

    public void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }
}
