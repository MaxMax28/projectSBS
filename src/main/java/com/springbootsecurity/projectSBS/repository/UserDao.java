package com.springbootsecurity.projectSBS.repository;

import com.springbootsecurity.projectSBS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User getUserByName (String name);

    //void deleteUserById (long id);
}
