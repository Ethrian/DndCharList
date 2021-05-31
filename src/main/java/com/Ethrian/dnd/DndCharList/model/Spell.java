package com.Ethrian.dnd.DndCharList.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String desc;

    @Enumerated(EnumType.STRING)
    private SpellLevel lvl;
    @Enumerated(EnumType.STRING)
    private SpellType type;

    private String castTime;
    private Integer distance;
    private String duration;

    private Boolean verbal;
    private Boolean somatic;
    private String material;


    public Spell() { }

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

    public SpellLevel getLvl() {
        return lvl;
    }

    public void setLvl(SpellLevel lvl) {
        this.lvl = lvl;
    }

    public SpellType getType() {
        return type;
    }

    public void setType(SpellType type) {
        this.type = type;
    }

    public String getCastTime() {
        return castTime;
    }

    public void setCastTime(String castTime) {
        this.castTime = castTime;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
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
}
