package com.Ethrian.dnd.DndCharList.model;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private Boolean dirty;

    public Bonus() { }

    public Bonus(String name, String description) {
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

    public Boolean getDirty() {
        return dirty;
    }

    public void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }
}
