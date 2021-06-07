package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Character;
import com.Ethrian.dnd.DndCharList.model.User;
import com.Ethrian.dnd.DndCharList.service.CharacterService;
import com.Ethrian.dnd.DndCharList.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping(value = "/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private CharacterService characterService;

    public UserController(
            UserService userService,
            CharacterService characterService
    ) {
        this.userService = userService;
        this.characterService = characterService;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView getCharactersPage() {
        return new ModelAndView("characters");
    }

    @RequestMapping(value = "/profilenew", method = RequestMethod.GET)
    public ModelAndView newCharacter() {
        return new ModelAndView("createCharacter");
    }

    @PostMapping(value = "/characternew")
    public ModelAndView createCharacter(
            HttpSession session,
            @RequestParam String name,
            @RequestParam String gender
    ){
        User user = userService.getUserById((Long) session.getAttribute("userId"));
        characterService.createCharacter(user, name, gender);
        List<Character> characters = userService.getUserCharacters(user);
        session.setAttribute("characters", characters);
        ModelAndView model = new ModelAndView("characters");
        model.addObject("characters", characters);
        return model;
    }
}
