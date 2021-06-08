package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Item;
import com.Ethrian.dnd.DndCharList.model.Race;
import com.Ethrian.dnd.DndCharList.service.RaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/race")
public class RaceController {

    private RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping
    public ModelAndView getRaces(){
        List<Race> races = raceService.getAllRaces();
        ModelAndView model = new ModelAndView("races");
        model.addObject("races", races);
        return model;
    }

    @GetMapping(value = "/{raceId}")
    public ModelAndView editRace(@PathVariable("raceId") Long id){
        Race race = raceService.getRace(id);
        ModelAndView model = new ModelAndView("editRace");
        model.addObject("race", race);
        return model;
    }


    @PostMapping(value = "/delete/{id}")
    public ModelAndView deleteRace(@PathVariable Long id){
        raceService.deleteRace(id);
        return new ModelAndView("redirect:/race");
    }

    @PostMapping
    public ModelAndView saveRace(
            @RequestParam("raceId") Long id,
            @RequestParam String name,
            @RequestParam String description
    ){
        raceService.updateName(id, name);
        Race race = raceService.updateDescription(id, description);
        return new ModelAndView("redirect:/race");
    }

    @PostMapping(value = "/new")
    public ModelAndView newRace(
            @RequestParam String name,
            @RequestParam String description
    ){
        Race race = raceService.createRace(name, description);
        return new ModelAndView("redirect:/race");
    }
}
