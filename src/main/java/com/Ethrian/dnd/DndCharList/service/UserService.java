package com.Ethrian.dnd.DndCharList.service;

import com.Ethrian.dnd.DndCharList.model.User;
import com.Ethrian.dnd.DndCharList.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private UserRepo userRepo;

    public UserService (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
//
//    public User createUser(
//            String username,
//            String mail,
//            String password,
//            String password2
//    ){
//        if(userRepo.findByUsername(username) == null) return null;
//        if(userRepo.findByMail(mail) == null) return null;
//        if(!password.equals(password2)) return null;
//
//        User newUser = new User(username, mail, password);
//        return userRepo.save(newUser);
//    }
}
