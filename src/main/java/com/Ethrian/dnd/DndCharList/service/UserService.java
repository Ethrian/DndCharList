package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.UserPrincipal;
import com.Ethrian.dnd.DndCharList.model.Role;
import com.Ethrian.dnd.DndCharList.model.User;
import com.Ethrian.dnd.DndCharList.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepo userRepo;

    public UserService (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null && validateUser(user)) {
            user.setActive(true);
            return new UserPrincipal(user);
        }
        else throw new UsernameNotFoundException("User not found");
    }

    public User signIn(String username, String password) {
        User user = userRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password) && validateUser(user)) {
            user.setActive(true);
            return user;
        }
        return null;
    }

    private boolean validateUser(User user) {
        Set<Role> roles = user.getRoles();
        return !roles.isEmpty();
    }

    public User getUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow();
        return user;
    }
}
