package com.Ethrian.dnd.DndCharList.model;

import javax.persistence.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item implements IBonusable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    private Double weight;
    @CollectionTable(name = "item_type", joinColumns = @JoinColumn(name = "item_id"))
    @Enumerated(EnumType.STRING)
    private ItemType type;
    private Integer amount;

    @ManyToMany
    @CollectionTable(name = "item_bonus", joinColumns = @JoinColumn(name = "bonus_id"))
    private Set<Bonus> itemBonuses;

    public Item() { }

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

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
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
}
