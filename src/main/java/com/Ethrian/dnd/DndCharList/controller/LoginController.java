package com.Ethrian.dnd.DndCharList.controller;

import com.Ethrian.dnd.DndCharList.model.Character;
import com.Ethrian.dnd.DndCharList.model.Role;
import com.Ethrian.dnd.DndCharList.model.User;
import com.Ethrian.dnd.DndCharList.model.UserPrincipal;
import com.Ethrian.dnd.DndCharList.repo.UserRepo;
import com.Ethrian.dnd.DndCharList.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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

    @GetMapping(value = {"/login", "/", ""})
    public String login() {
        return "login";
    }

    @PostMapping(value = "/login")
    public ModelAndView signIn(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session
    ) {
        User user = userService.signIn(username, password);
        if (user == null) {
            ModelAndView model = new ModelAndView("login");
            model.addObject("message", "Wrong username of password");
            return model;
        }
        session.setAttribute("userId", user.getId());
        session.setAttribute("user", user);
        ModelAndView model = new ModelAndView("redirect:/profile");
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

        return "login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView getCharactersPage(HttpServletRequest request) {
        HttpSession session= request.getSession(false);
        User user;
        if (session.getAttribute("userId") == null) {
            if (SecurityContextHolder.getContext().getAuthentication() != null) {
                user = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
            } else {
                doLogout(request);
                return new ModelAndView("logout");
            }
        } else {
            user = userService.getUserById((Long) session.getAttribute("userId"));
        }
        if (session.getAttribute("user") == null)
            session.setAttribute("user", user);
        List<Character> characters = userService.getUserCharacters(user);
        ModelAndView model = new ModelAndView("characters");
        model.addObject("characters", characters);
        return model;
    }

    @GetMapping ("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        doLogout(request);
        return new ModelAndView("logout");
    }

    private void doLogout(HttpServletRequest request) {
        HttpSession session= request.getSession(false);
        SecurityContextHolder.clearContext();
        session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        for(Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }
    }
}
