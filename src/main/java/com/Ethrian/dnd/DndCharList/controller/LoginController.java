package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Role;
import com.Ethrian.dnd.DndCharList.repo.UserRepo;
import com.Ethrian.dnd.DndCharList.model.User;
import com.Ethrian.dnd.DndCharList.service.CharacterService;
import com.Ethrian.dnd.DndCharList.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
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
    public String signIn(
            @RequestParam String username,
            @RequestParam String password,
            RedirectAttributes redirectAttrs,
            Map<String, Object> model
    ) {
        User user = userService.signIn(username, password);
        if (user == null) {
            model.put("message", "Wrong username of password");
            return "signIn";
        }
        redirectAttrs.addAttribute("userId", user.getId());
        return "redirect:/user";
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
