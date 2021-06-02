package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.*;
import com.Ethrian.dnd.DndCharList.repo.BonusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public class BonusController {

    @Autowired
    private BonusRepo bonusRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String getBonus(@RequestParam Bonus bonus, Map<String, Object> model){

        return "";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addBonusToBonusable(@RequestParam Bonus bonus, @RequestParam IBonusable bonusable, Map<String, Object> model){

        return "";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String updateBonusAbility(
            @RequestParam Bonus bonus,
            @RequestParam Integer STR,
            @RequestParam Integer DEX,
            @RequestParam Integer CON,
            @RequestParam Integer INT,
            @RequestParam Integer WIS,
            @RequestParam Integer CHA,
            Map<String, Object> model
    ){

        return "";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String updateBonusSkills(
            @RequestParam Bonus bonus,
            @RequestParam CharacterSkill skill,
            Map<String, Object> model
    ){

        return "";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String updateBonusStats(
            @RequestParam Integer hp,
            @RequestParam Integer armorClass,
            @RequestParam Integer initiative,
            @RequestParam Integer speed,
            @RequestParam Integer prof,
            Map<String, Object> model
    ){

        return "";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String updateBonusSpells(
            @RequestParam Bonus bonus,
            @RequestParam Spell spell,
            Map<String, Object> model
    ){

        return "";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String updateBonusDescription(
            @RequestParam Bonus bonus,
            @RequestParam String description,
            Map<String, Object> model
    ){

        return "";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String updateBonusImmunitiesAndResistances(
            @RequestParam Bonus bonus,
            @RequestParam DamageType damageType,
            @RequestParam Integer resistanceType,            // 0 - none, 1 - resistance, 2 - immunity
            Map<String, Object> model
    ){

        return "";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String deleteBonus(
            @RequestParam Bonus bonus,
            Map<String, Object> model
    ){
        return "";
    }

}
