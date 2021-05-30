package com.Ethrian.dnd.DndCharList.model;

import java.util.Set;

public class Item {

    private Long id;
    private String name;
    private String desc;

    private Double weight;
    private ItemType type;

    private Set<Bonus> itemBonuses;
}