package com.springbootsecurity.projectSBS.repository;

import com.springbootsecurity.projectSBS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findUserByName(String name);

    List<User> findAll();

}
