package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Character;
import com.Ethrian.dnd.DndCharList.model.Role;
import com.Ethrian.dnd.DndCharList.repo.UserRepo;
import com.Ethrian.dnd.DndCharList.model.User;
import com.Ethrian.dnd.DndCharList.service.CharacterService;
import com.Ethrian.dnd.DndCharList.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    private final UserRepo userRepo;
    private final UserService userService;

    public LoginController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @GetMapping(value = {"/signIn", "/"})
    public String login() {
        return "signIn";
    }

    @PostMapping(value = "/signIn")
    public ModelAndView signIn(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session
    ) {
        User user = userService.signIn(username, password);
        if (user == null) {
            ModelAndView model = new ModelAndView("signIn");
            model.addObject("message", "Wrong username of password");
            return model;
        }
        session.setAttribute("userId", user.getId());
        ModelAndView model = new ModelAndView("redirect:/profile");
        List<Character> characters = userService.getUserCharacters(user);
        session.setAttribute("characters", characters);
        return model;
    }

    @GetMapping(value = "/signUp")
    public String signUp() {
        return "signUp";
    }

    @PostMapping(value = "/signUp")
    public String registerNewUser(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "mail") String mail,
            @RequestParam(name = "password") String password,
            Map<String, Object> model
    ) {
        User dbUser = userRepo.findByUsername(username);

        if (dbUser != null) {
            model.put("message", 0);
            return "signUp";
        }
        User user = new User(username, mail, password);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "signIn";
    }
}
