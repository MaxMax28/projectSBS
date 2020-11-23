package com.springbootsecurity.projectSBS.service;

import com.springbootsecurity.projectSBS.model.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.springbootsecurity.projectSBS.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findUserByName(String name);

    List<User> findAll();

    void deleteUserById(long id);

    User findUserById(long id);

    Role getRoleById(long id);

    void updateUser(User user);

    void save(User user);

    Role getRoleByRole(String role);
}
