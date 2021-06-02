package com.Ethrian.dnd.DndCharList.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;
    @ManyToOne
    @JoinColumn(name = "characterClass")
    private CharacterClass characterClass;
    private String background;
    private String gender;
    private String appearence;
    private Integer exp;
    private Integer maxHP;
    private Integer curHP;
    private Integer tmpHP;
    private Integer armorClass;
    private Integer initiative;
    private Integer speed;
    private Integer curHitDices;
    private Integer deathSavesFailed;
    private Integer deathSavesPassed;
    @ManyToMany
    @CollectionTable(name = "character_items", joinColumns = @JoinColumn(name = "character_id"))
    private Set<Item> items;
    private Integer cp;
    private Integer sp;
    private Integer gp;
    private Integer pp;
    @ManyToMany
    @CollectionTable(name = "character_spells", joinColumns = @JoinColumn(name = "character_id"))
    private Set<Spell> spells;
    private Integer profBonus;
    private Integer lvl1Max;
    private Integer lvl2Max;
    private Integer lvl3Max;
    private Integer lvl4Max;
    private Integer lvl5Max;
    private Integer lvl6Max;
    private Integer lvl7Max;
    private Integer lvl8Max;
    private Integer lvl9Max;
    private Integer lvl1Cur;
    private Integer lvl2Cur;
    private Integer lvl3Cur;
    private Integer lvl4Cur;
    private Integer lvl5Cur;
    private Integer lvl6Cur;
    private Integer lvl7Cur;
    private Integer lvl8Cur;
    private Integer lvl9Cur;

    private Integer STR;
    private Integer DEX;
    private Integer CON;
    private Integer INT;
    private Integer WIS;
    private Integer CHA;

    private Integer athleticBonus;
    private Integer acrotabicBonus;
    private Integer sleightOfHandsBonus;
    private Integer stealthBonus;
    private Integer investigationBonus;
    private Integer historyBonus;
    private Integer natureBonus;
    private Integer arcanaBonus;
    private Integer religionBonus;
    private Integer perceptionBonus;
    private Integer insightBonus;
    private Integer survivalBonus;
    private Integer medicineBonus;
    private Integer animalHandlingBonus;
    private Integer decetpionBonus;
    private Integer intimidationBonus;
    private Integer performanceBonus;
    private Integer persuationBonus;

    @ManyToMany
    @CollectionTable(name = "character_bonus", joinColumns = @JoinColumn(name = "character_id"))
    private Set<Bonus> otherBonuses;


    public Character() { }

    public Character(String name, String gender, Race race) {
        this.name = name;
        this.gender = gender;
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAppearence() {
        return appearence;
    }

    public void setAppearence(String appearence) {
        this.appearence = appearence;
    }

    public void setSpells(Set<Spell> spells) {
        this.spells = spells;
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

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(Integer maxHP) {
        this.maxHP = maxHP;
    }

    public Integer getCurHP() {
        return curHP;
    }

    public void setCurHP(Integer curHP) {
        this.curHP = curHP;
    }

    public Integer getTmpHP() {
        return tmpHP;
    }

    public void setTmpHP(Integer tmpHP) {
        this.tmpHP = tmpHP;
    }

    public Integer getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getCurHitDices() {
        return curHitDices;
    }

    public void setCurHitDices(Integer curHitDices) {
        this.curHitDices = curHitDices;
    }

    public Integer getDeathSavesFailed() {
        return deathSavesFailed;
    }

    public void setDeathSavesFailed(Integer deathSavesFailed) {
        this.deathSavesFailed = deathSavesFailed;
    }

    public Integer getDeathSavesPassed() {
        return deathSavesPassed;
    }

    public void setDeathSavesPassed(Integer deathSavesPassed) {
        this.deathSavesPassed = deathSavesPassed;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public Integer getSp() {
        return sp;
    }

    public void setSp(Integer sp) {
        this.sp = sp;
    }

    public Integer getGp() {
        return gp;
    }

    public void setGp(Integer gp) {
        this.gp = gp;
    }

    public Integer getPp() {
        return pp;
    }

    public void setPp(Integer pp) {
        this.pp = pp;
    }

    public Set<Spell> getSpells() {
        return spells;
    }

    public void setSpellsList(Set<Spell> spells) {
        this.spells = spells;
    }

    public Integer getProfBonus() {
        return profBonus;
    }

    public void setProfBonus(Integer profBonus) {
        this.profBonus = profBonus;
    }

    public Integer getLvl1Max() {
        return lvl1Max;
    }

    public void setLvl1Max(Integer lvl1Max) {
        this.lvl1Max = lvl1Max;
    }

    public Integer getLvl2Max() {
        return lvl2Max;
    }

    public void setLvl2Max(Integer lvl2Max) {
        this.lvl2Max = lvl2Max;
    }

    public Integer getLvl3Max() {
        return lvl3Max;
    }

    public void setLvl3Max(Integer lvl3Max) {
        this.lvl3Max = lvl3Max;
    }

    public Integer getLvl4Max() {
        return lvl4Max;
    }

    public void setLvl4Max(Integer lvl4Max) {
        this.lvl4Max = lvl4Max;
    }

    public Integer getLvl5Max() {
        return lvl5Max;
    }

    public void setLvl5Max(Integer lvl5Max) {
        this.lvl5Max = lvl5Max;
    }

    public Integer getLvl6Max() {
        return lvl6Max;
    }

    public void setLvl6Max(Integer lvl6Max) {
        this.lvl6Max = lvl6Max;
    }

    public Integer getLvl7Max() {
        return lvl7Max;
    }

    public void setLvl7Max(Integer lvl7Max) {
        this.lvl7Max = lvl7Max;
    }

    public Integer getLvl8Max() {
        return lvl8Max;
    }

    public void setLvl8Max(Integer lvl8Max) {
        this.lvl8Max = lvl8Max;
    }

    public Integer getLvl9Max() {
        return lvl9Max;
    }

    public void setLvl9Max(Integer lvl9Max) {
        this.lvl9Max = lvl9Max;
    }

    public Integer getLvl1Cur() {
        return lvl1Cur;
    }

    public void setLvl1Cur(Integer lvl1Cur) {
        this.lvl1Cur = lvl1Cur;
    }

    public Integer getLvl2Cur() {
        return lvl2Cur;
    }

    public void setLvl2Cur(Integer lvl2Cur) {
        this.lvl2Cur = lvl2Cur;
    }

    public Integer getLvl3Cur() {
        return lvl3Cur;
    }

    public void setLvl3Cur(Integer lvl3Cur) {
        this.lvl3Cur = lvl3Cur;
    }

    public Integer getLvl4Cur() {
        return lvl4Cur;
    }

    public void setLvl4Cur(Integer lvl4Cur) {
        this.lvl4Cur = lvl4Cur;
    }

    public Integer getLvl5Cur() {
        return lvl5Cur;
    }

    public void setLvl5Cur(Integer lvl5Cur) {
        this.lvl5Cur = lvl5Cur;
    }

    public Integer getLvl6Cur() {
        return lvl6Cur;
    }

    public void setLvl6Cur(Integer lvl6Cur) {
        this.lvl6Cur = lvl6Cur;
    }

    public Integer getLvl7Cur() {
        return lvl7Cur;
    }

    public void setLvl7Cur(Integer lvl7Cur) {
        this.lvl7Cur = lvl7Cur;
    }

    public Integer getLvl8Cur() {
        return lvl8Cur;
    }

    public void setLvl8Cur(Integer lvl8Cur) {
        this.lvl8Cur = lvl8Cur;
    }

    public Integer getLvl9Cur() {
        return lvl9Cur;
    }

    public void setLvl9Cur(Integer lvl9Cur) {
        this.lvl9Cur = lvl9Cur;
    }

    public Integer getSTR() {
        return STR;
    }

    public void setSTR(Integer STR) {
        this.STR = STR;
    }

    public Integer getDEX() {
        return DEX;
    }

    public void setDEX(Integer DEX) {
        this.DEX = DEX;
    }

    public Integer getCON() {
        return CON;
    }

    public void setCON(Integer CON) {
        this.CON = CON;
    }

    public Integer getINT() {
        return INT;
    }

    public void setINT(Integer INT) {
        this.INT = INT;
    }

    public Integer getWIS() {
        return WIS;
    }

    public void setWIS(Integer WIS) {
        this.WIS = WIS;
    }

    public Integer getCHA() {
        return CHA;
    }

    public void setCHA(Integer CHA) {
        this.CHA = CHA;
    }

    public Set<Bonus> getOtherBonuses() {
        return otherBonuses;
    }

    public void setOtherBonuses(Set<Bonus> otherBonuses) {
        this.otherBonuses = otherBonuses;
    }

    public Integer getAthleticBonus() {
        return athleticBonus;
    }

    public void setAthleticBonus(Integer athleticBonus) {
        this.athleticBonus = athleticBonus;
    }

    public Integer getAcrotabicBonus() {
        return acrotabicBonus;
    }

    public void setAcrotabicBonus(Integer acrotabicBonus) {
        this.acrotabicBonus = acrotabicBonus;
    }

    public Integer getSleightOfHandsBonus() {
        return sleightOfHandsBonus;
    }

    public void setSleightOfHandsBonus(Integer sleightOfHandsBonus) {
        this.sleightOfHandsBonus = sleightOfHandsBonus;
    }

    public Integer getStealthBonus() {
        return stealthBonus;
    }

    public void setStealthBonus(Integer stealthBonus) {
        this.stealthBonus = stealthBonus;
    }

    public Integer getInvestigationBonus() {
        return investigationBonus;
    }

    public void setInvestigationBonus(Integer investigationBonus) {
        this.investigationBonus = investigationBonus;
    }

    public Integer getHistoryBonus() {
        return historyBonus;
    }

    public void setHistoryBonus(Integer historyBonus) {
        this.historyBonus = historyBonus;
    }

    public Integer getNatureBonus() {
        return natureBonus;
    }

    public void setNatureBonus(Integer natureBonus) {
        this.natureBonus = natureBonus;
    }

    public Integer getArcanaBonus() {
        return arcanaBonus;
    }

    public void setArcanaBonus(Integer arcanaBonus) {
        this.arcanaBonus = arcanaBonus;
    }

    public Integer getReligionBonus() {
        return religionBonus;
    }

    public void setReligionBonus(Integer religionBonus) {
        this.religionBonus = religionBonus;
    }

    public Integer getPerceptionBonus() {
        return perceptionBonus;
    }

    public void setPerceptionBonus(Integer perceptionBonus) {
        this.perceptionBonus = perceptionBonus;
    }

    public Integer getInsightBonus() {
        return insightBonus;
    }

    public void setInsightBonus(Integer insightBonus) {
        this.insightBonus = insightBonus;
    }

    public Integer getSurvivalBonus() {
        return survivalBonus;
    }

    public void setSurvivalBonus(Integer survivalBonus) {
        this.survivalBonus = survivalBonus;
    }

    public Integer getMedicineBonus() {
        return medicineBonus;
    }

    public void setMedicineBonus(Integer medicineBonus) {
        this.medicineBonus = medicineBonus;
    }

    public Integer getAnimalHandlingBonus() {
        return animalHandlingBonus;
    }

    public void setAnimalHandlingBonus(Integer animalHandlingBonus) {
        this.animalHandlingBonus = animalHandlingBonus;
    }

    public Integer getDecetpionBonus() {
        return decetpionBonus;
    }

    public void setDecetpionBonus(Integer decetpionBonus) {
        this.decetpionBonus = decetpionBonus;
    }

    public Integer getIntimidationBonus() {
        return intimidationBonus;
    }

    public void setIntimidationBonus(Integer intimidationBonus) {
        this.intimidationBonus = intimidationBonus;
    }

    public Integer getPerformanceBonus() {
        return performanceBonus;
    }

    public void setPerformanceBonus(Integer performanceBonus) {
        this.performanceBonus = performanceBonus;
    }

    public Integer getPersuationBonus() {
        return persuationBonus;
    }

    public void setPersuationBonus(Integer persuationBonus) {
        this.persuationBonus = persuationBonus;
    }

}
