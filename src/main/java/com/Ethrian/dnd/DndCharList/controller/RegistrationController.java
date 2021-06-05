package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.repo.UserRepo;
import com.Ethrian.dnd.DndCharList.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private final UserRepo userRepo;

    public RegistrationController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/signUp")
    public String register(Map<String, Object> model) {
        return "signUp";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
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
        userRepo.save(user);

        return "redirect:/signIn";
    }
}