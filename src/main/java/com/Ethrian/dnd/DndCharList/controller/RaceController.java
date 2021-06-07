package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Race;
import com.Ethrian.dnd.DndCharList.service.RaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "user/{userid}/race")
public class RaceController {

    private RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping(name = "/")
    public String getRaces(Map<String, Object> model){
        List<Race> races = raceService.getAllRaces();
        model.put("races", races);
        return "/races";
    }

    @GetMapping(name = "/{raceId}")
    public String editRace(@PathVariable Long id, Map<String, Object> model){
        Race race = raceService.getRace(id);
        model.put("race", race);
        return "/editRace";
    }

    @GetMapping(name = "/delete")
    public String deleteRace(@PathVariable Long id, Map<String, Object> model){
        raceService.deleteRace(id);
        return "redirect:/races";
    }


    @PostMapping(name = "/{raceId}")
    public String saveRace(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String description,
            Map<String, Object> model
    ){
        raceService.updateName(id, name);
        Race race = raceService.updateDescription(id, description);
        model.put("race", race);
        return "redirect:/races";
    }

    @PostMapping(name = "/new")
    public String newRace(
            @RequestParam String name,
            @RequestParam String description,
            Map<String, Object> model
    ){
        Race race = raceService.createRace(name, description);
        model.put("race", race);
        return "redirect:/races";
    }
}
