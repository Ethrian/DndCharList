package com.Ethrian.dnd.DndCharList.model;

import javax.persistence.*;

@Entity
public class CharacterSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CollectionTable(name = "characterSkill_skill", joinColumns = @JoinColumn(name = "characterSkill_id"))
    @Enumerated(EnumType.STRING)
    private Skill skill;
    @CollectionTable(name = "characterSkill_prof", joinColumns = @JoinColumn(name = "characterSkill_id"))
    @Enumerated(EnumType.STRING)
    private Proficiency skillProf;
    private Integer bonus;
}
