package com.springbootsecurity.projectSBS.repository;

import com.springbootsecurity.projectSBS.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

    Role getRoleById(long id);
    Role getRoleByRole(String role);
}
