package com.springbootsecurity.projectSBS.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.springbootsecurity.projectSBS.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    boolean addUser(User user);

    void updateUser(User user);

    User getUserById(long id);

    //User getUserByName(String name);

    List<User> getAllUsers();

    void deleteUser(long id);
}
