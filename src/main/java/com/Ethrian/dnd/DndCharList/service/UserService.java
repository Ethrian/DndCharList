package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.Role;
import com.Ethrian.dnd.DndCharList.model.User;
import com.Ethrian.dnd.DndCharList.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        if (validateUser(user)) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Role role: user.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
            }
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
            logger.info("UserDetails: {}", userDetails);
            return userDetails;
        }
        else throw new UsernameNotFoundException("User not found");
    }

    public User signIn(String username, String password) {
        User user = userRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password) && validateUser(user)) {
            return user;
        }
        return null;
    }

    private boolean validateUser(User user) {
        Set<Role> roles = user.getRoles();
        return !roles.isEmpty();
    }
}
