package com.Ethrian.dnd.DndCharList.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item implements IBonusable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String desc;

    private Double weight;
    @Enumerated(EnumType.STRING)
    private ItemType type;
    private Integer amount;

    @ManyToMany
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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