package com.Ethrian.dnd.DndCharList.repo;

import com.Ethrian.dnd.DndCharList.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User findByUsername(String name);

    User findByMail(String mail);
}
