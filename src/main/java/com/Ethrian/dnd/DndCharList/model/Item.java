package com.Ethrian.dnd.DndCharList.model;

import javax.persistence.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(columnDefinition = "text")
    private String description;

    private Double weight;
    private String itemType;
    private Integer amount;
    private Boolean dirty;

    @ManyToMany
    @CollectionTable(name = "item_bonus", joinColumns = @JoinColumn(name = "bonus_id"))
    private Set<Bonus> itemBonuses;

    public Item() { }

    public Item(String name, String description, Double weight, String itemType, Integer amount) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.itemType = itemType;
        this.amount = amount;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<Bonus> getItemBonuses() {
        return itemBonuses;
    }

    public void setItemBonuses(Set<Bonus> itemBonuses) {
        this.itemBonuses = itemBonuses;
    }

    public void addBonusToItem(Bonus bonus) {
        this.itemBonuses.add(bonus);
    }

    public Boolean getDirty() {
        return dirty;
    }

    public void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }
}
