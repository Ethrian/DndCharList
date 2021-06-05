package com.Ethrian.dnd.DndCharList.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User findByUsername(String name);

    User findByMail(String mail);
}
